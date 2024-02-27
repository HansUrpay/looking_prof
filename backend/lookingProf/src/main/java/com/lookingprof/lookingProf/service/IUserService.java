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

    public Optional<List<UserResponseDTO>> listAll();
    public Optional<UserResponseDTO> findById(Integer id);
    public String deleteUser(Integer id);
    public Optional<UserResponseDTO> updateUser(Integer id, UserResponseDTO userDTO);
    public Optional<List<UserResponseDTO>> findByFirstname(String firstName);
    public Optional<UserResponseDTO> findByEmail(String email);

    public Optional<List<UserRequestDTO>> findByProfession(String profession);
    public Optional<List<UserRequestDTO>> findByProvince(String province);
    public Optional<List<UserRequestDTO>> findByCity(String city);
    public Optional<List<UserRequestDTO>> findByQualification(int qualification);

    public AuthResponse loginUser(LoginRequest user);
    public AuthResponse registerUser(RegisterRequest user);
    public UserDetails loadUserByUsername(String username);
    public List<UserResponseDTO> listAllActives();

}
