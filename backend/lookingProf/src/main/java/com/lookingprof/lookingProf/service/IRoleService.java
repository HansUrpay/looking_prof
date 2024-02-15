package com.lookingprof.lookingProf.service;


import com.lookingprof.lookingProf.model.Role;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface IRoleService {

    public List<Role> findByName(String name);


    public List<Role> listAll();

}
