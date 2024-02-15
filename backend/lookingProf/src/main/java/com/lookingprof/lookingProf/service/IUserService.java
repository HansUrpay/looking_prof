package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findByUserName(String userName);
    public List<User> findAllByProfession(Profession profession);
    public List<User> findByProvince(String province);
    public List<User> findByCountry(String country);
    public List<User> findByCity(String city);
    public List<User> findByQualification();
    public List<User> listAll();

}
