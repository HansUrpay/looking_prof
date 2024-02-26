package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.Auth.AuthResponse;
import com.lookingprof.lookingProf.Auth.LoginRequest;
import com.lookingprof.lookingProf.Auth.RegisterRequest;
import com.lookingprof.lookingProf.dto.UserRequestDTO;
import com.lookingprof.lookingProf.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    public Optional<List<UserRequestDTO>> listAll();
    public Optional<UserRequestDTO> findById(Integer id);
    public Optional<User> deleteUser(Integer id);
    public Optional<UserRequestDTO> updateUser(Integer id, UserRequestDTO userDTO);
    public Optional<List<UserRequestDTO>> findByFirstname(String firstName);
    public Optional<UserRequestDTO> findByEmail(String email);

    public Optional<List<UserRequestDTO>> findByProfession(String profession);
    public Optional<List<UserRequestDTO>> findByProvince(String province);
    public Optional<List<UserRequestDTO>> findByCity(String city);
    public Optional<List<UserRequestDTO>> findByQualification(int qualification);

    public AuthResponse loginUser(LoginRequest user);
    public AuthResponse registerUser(RegisterRequest user);
    public UserDetails loadUserByUsername(String username);

}
