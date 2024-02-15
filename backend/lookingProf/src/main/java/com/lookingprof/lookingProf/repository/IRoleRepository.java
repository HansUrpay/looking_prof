package com.lookingprof.lookingProf.repository;


import com.lookingprof.lookingProf.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByName(String name);
}
