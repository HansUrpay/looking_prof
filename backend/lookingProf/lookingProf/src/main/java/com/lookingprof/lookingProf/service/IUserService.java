package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;

import java.util.List;

public interface IUserService {

    public List<User> findByName(String userName);
    public List<User> listAllByProfession(Profession profession);
    public List<User> listByProvince(String province);
    public List<User> listByCountry(String country);
    public List<User> listByCity(String city);
    public List<User> listByQualification();
    public List<User> listAll();

}
