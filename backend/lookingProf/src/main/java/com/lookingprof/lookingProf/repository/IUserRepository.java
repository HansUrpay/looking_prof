package com.lookingprof.lookingProf.repository;

import com.lookingprof.lookingProf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<UserDetails> findByEmail(String email);
}
