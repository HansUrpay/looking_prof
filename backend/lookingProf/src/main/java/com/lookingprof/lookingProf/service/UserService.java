package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public List<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
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
    public List<User> listAll() {
        return userRepository.findAll();
    }

}
