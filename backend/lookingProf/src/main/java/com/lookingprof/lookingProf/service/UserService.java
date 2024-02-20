package com.lookingprof.lookingProf.service;

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
    public List<User> findByName(String userName) {
        return null;
    }

    @Override
    public List<User> listAllByProfession(Profession profession) {
        return null;
    }

    @Override
    public List<User> listByProvince(String province) {
        return null;
    }

    @Override
    public List<User> listByCountry(String country) {
        return null;
    }

    @Override
    public List<User> listByCity(String city) {
        return null;
    }

    @Override
    public List<User> listByQualification() {
        return null;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
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
