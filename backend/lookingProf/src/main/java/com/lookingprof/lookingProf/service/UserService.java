package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;


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
}
