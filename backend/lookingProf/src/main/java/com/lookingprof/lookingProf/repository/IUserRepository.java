package com.lookingprof.lookingProf.repository;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Integer> {

    List<User> findByUserName(String userName);

    List<User> findAllByProfession(Profession profession);

    List<User> findByProvince(String province);

    List<User> findByCountry(String country);

    List<User> findByCity(String city);

    //@Query("SELECT u FROM User u WHERE u.qualification IS NOT NULL")
    List<User> findByQualification();

}
