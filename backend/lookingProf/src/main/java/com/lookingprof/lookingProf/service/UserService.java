package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.Auth.AuthResponse;
import com.lookingprof.lookingProf.Auth.LoginRequest;
import com.lookingprof.lookingProf.Auth.RegisterRequest;
import com.lookingprof.lookingProf.dto.UserResponseDTO;
import com.lookingprof.lookingProf.exceptions.UserDeleteException;
import com.lookingprof.lookingProf.exceptions.UserNotFoundException;
import com.lookingprof.lookingProf.jwt.JwtService;
import com.lookingprof.lookingProf.model.Enum.Role;
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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtService jwtService;

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findByName(String firstName) {
        List<User> users = userRepository.findByFirstName(firstName);

            if (users.isEmpty()) {
                throw new UserNotFoundException("Error al buscar usuarios por nombre: " + firstName);
            }
        List<UserResponseDTO> listUserDTO = new ArrayList<>();
        users.forEach(user -> {
            UserResponseDTO userResponseDTO = new UserResponseDTO(user);
            listUserDTO.add(userResponseDTO);
        } );
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
    public AuthResponse loginUser(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        User user = userRepository.findByEmail(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder().token(token).build();
    }

    @Override
    public AuthResponse registerUser(RegisterRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER);
        userRepository.save(user);
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
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
