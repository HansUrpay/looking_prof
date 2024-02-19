package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    public List<User> findByName(String userName);
    public List<User> listAllByProfession(Profession profession);
    public List<User> listByProvince(String province);
    public List<User> listByCountry(String country);
    public List<User> listByCity(String city);
    public List<User> listByQualification();
    public List<User> listAll();
    public Optional<User> findById(Integer id);

    public ResponseEntity<String> loginUser(User user);

    public ResponseEntity<String> loginUser(User user);

}
