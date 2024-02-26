package com.lookingprof.lookingProf.controller;

import com.lookingprof.lookingProf.dto.UserRequestDTO;
import com.lookingprof.lookingProf.model.User;
import com.lookingprof.lookingProf.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("user")
//@CrossOrigin(value = )
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllUsers() {
        Optional<List<UserRequestDTO>> optionalUsers = userService.listAll();

        if (optionalUsers.isPresent()) {
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id) {
        Optional<User> deletedUser = userService.deleteUser(id);
        if (deletedUser.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody UserRequestDTO userUpdate) {
        Optional<UserRequestDTO> updatedUser = userService.updateUser(id, userUpdate);
        if (updatedUser.isPresent()) {
            return ResponseEntity.ok(updatedUser.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id){
        Optional<UserRequestDTO> userResponseDTO = userService.findById(id);
        if(userResponseDTO.isPresent()){
            return new ResponseEntity<>(userResponseDTO, HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
    }

    @GetMapping("/firstName")
    public ResponseEntity<?> findByFirstname(@RequestParam String firstName){
        Optional<List<UserRequestDTO>> optionalUsers = userService.findByFirstname(firstName);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/email")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        Optional<UserRequestDTO> optionalUsers = userService.findByEmail(email);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/province")
    public ResponseEntity<?> findByProvince(@RequestParam String province){
        Optional<List<UserRequestDTO>> optionalUsers = userService.findByProvince(province);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/city")
    public ResponseEntity<?> findByCity(@RequestParam String city){
        Optional<List<UserRequestDTO>> optionalUsers = userService.findByCity(city);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/profession")
    public ResponseEntity<?> findByProfession(@RequestParam String profession){
        Optional<List<UserRequestDTO>> optionalUsers = userService.findByProfession(profession);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

    @GetMapping("/qualification/{qualification}")
    public ResponseEntity<?> findByQualification(@PathVariable int qualification){
        Optional<List<UserRequestDTO>> optionalUsers = userService.findByQualification(qualification);
        if (optionalUsers.isPresent()){
            return ResponseEntity.ok(optionalUsers.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron usuarios");
        }
    }

}
