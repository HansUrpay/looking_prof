package com.lookingprof.lookingProf.repository;

import com.lookingprof.lookingProf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
