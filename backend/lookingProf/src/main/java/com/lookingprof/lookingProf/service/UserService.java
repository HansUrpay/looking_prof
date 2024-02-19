package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.jwt.JwtService;
import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    public ResponseEntity<String> loginUser (User user){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
        String token = jwtService.getToken(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

}
