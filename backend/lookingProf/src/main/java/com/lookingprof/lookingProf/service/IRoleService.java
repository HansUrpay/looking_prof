package com.lookingprof.lookingProf.service;


import java.util.List;

public interface IRoleService {

    public List<Role> findByName(String name);


    public List<Role> listAll();

}
