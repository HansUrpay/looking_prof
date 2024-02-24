package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.Auth.AuthResponse;
import com.lookingprof.lookingProf.Auth.LoginRequest;
import com.lookingprof.lookingProf.Auth.RegisterRequest;
import com.lookingprof.lookingProf.dto.UserResponseDTO;
import com.lookingprof.lookingProf.model.City;
import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.Province;
import com.lookingprof.lookingProf.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface IUserService extends UserDetailsService {

    public Optional<List<UserResponseDTO>> listAll();
    public Optional<User> findById(Integer id);
    public Optional<User> deleteUser(Integer id);
    public Optional<UserResponseDTO> updateUser(Integer id, User user);
    public Optional<List<UserResponseDTO>> findByFirstname(String userName);
    public Optional<UserResponseDTO> findByEmail(String email);
    public Optional<List<UserResponseDTO>> findByProfession(Profession profession);
    public Optional<List<UserResponseDTO>> findByProvince(Province province);
    public Optional<List<UserResponseDTO>> findByCity(City city);
    public Optional<List<UserResponseDTO>> findByQualification(int qualification);

    public AuthResponse loginUser(LoginRequest user);
    public AuthResponse registerUser(RegisterRequest user);
    public UserDetails loadUserByUsername(String username);

}
