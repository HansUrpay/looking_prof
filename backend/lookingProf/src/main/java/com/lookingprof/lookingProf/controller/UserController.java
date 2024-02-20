package com.lookingprof.lookingProf.controller;

import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
//@CrossOrigin(value = )
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @GetMapping("/")
    public List<User> getAllUser(){
        var users = userService.listAll();
        return users;
      }

    @GetMapping("/user")
    public List<User> findByName(@RequestParam String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/province")
    public List<User> findByProvince(@RequestParam String province){
        return userService.findByProvince(province);
    }

}
