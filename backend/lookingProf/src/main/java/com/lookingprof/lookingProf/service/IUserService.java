package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {


    public List<User> findByUserName(String userName);
    public List<User> findAllByProfession(Profession profession);
    public List<User> findByProvince(String province);
    public List<User> findByCountry(String country);
    public List<User> findByCity(String city);
    public List<User> findByQualification();
    public List<User> findByName(String userName);
    public Optional<User> deleteUser(Integer id);
    public Optional<User> findByEmail(String email);

    public List<User> listAll();
    public Optional<User> findById(Integer id);
    public ResponseEntity<String> loginUser(UserDetails user);
    public UserDetails loadUserByUsername(String username);

}
