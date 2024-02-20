package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.exceptions.UserDeleteException;
import com.lookingprof.lookingProf.exceptions.UserNotFoundException;
import com.lookingprof.lookingProf.jwt.JwtService;
import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByUserName(String userName) {
        List<User> users = userRepository.findByUserName(userName);
            if (users.isEmpty()) {
                throw new UserNotFoundException("Error al buscar usuarios por nombre: " + userName);
            }
        return users;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Error al buscar el usuario con email: " + email);
        }
        return user;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Error al buscar el usuario con id: " + id);
        }
        return user;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Optional<User> deleteUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new UserNotFoundException("Error al buscar el usuario con id: " + id);
        }
        User userDelete = user.get();
            try {
                userRepository.delete(userDelete);
                return user;
            } catch (Exception e){
                e.printStackTrace();
                throw new UserDeleteException("Error al eliminar el usuario con ID: " + id, e);
            }
    }

    @Override
    public List<User> findAllByProfession(Profession profession) {
        return userRepository.findAllByProfession(profession);
    }
    @Override
    public List<User> findByProvince(String province) {
        return userRepository.findByProvince(province);
    }
    @Override
    public List<User> findByCountry(String country) {
        return userRepository.findByCountry(country);
    }
    @Override
    public List<User> findByCity(String city) {
        return userRepository.findByCity(city);
    }
    @Override
    public List<User> findByQualification() {
        return userRepository.findByQualification();
    }

    @Override
    public ResponseEntity<String> loginUser(UserDetails user) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        UserDetails userDetails = userRepository.findByEmail(user.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("The user does not exists"));

        return new org.springframework.security.core.userdetails.User(
                userDetails.getUsername(),
                "",
                userDetails.getAuthorities()
        );
    }

}
