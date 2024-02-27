package com.lookingprof.lookingProf.dto;

<<<<<<< HEAD
import com.lookingprof.lookingProf.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private int idUser;
    private LocalDateTime createAt;
    private String address;
    private String email;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String phone;
    private String profession;
    private String province;
    private String city;


    public UserRequestDTO(User user){
        this.idUser=user.getIdUser();
        this.createAt=user.getCreateAt();
        this.address= user.getAddress();
        this.email= user.getEmail();
        this.firstName= user.getFirstName();
        this.lastName= user.getLastName();
        this.profession= user.getProfession().getNameProfession();
        this.province= user.getProvince().getNameProvince();
        this.city= user.getCity().getNameCity();
    }

=======
import com.lookingprof.lookingProf.model.City;
import com.lookingprof.lookingProf.model.Comment;
import com.lookingprof.lookingProf.model.Enum.Role;
import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.model.Province;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequestDTO {
//aca van los campos para editar y crear el usuario
    private String lastName;
    private String firstName;
    private String province;
    private String city;
    private Integer qualification;
    private String profession;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String description;
>>>>>>> f25e2d1cc8c012b410fa493f99fbedd2957b641d
}
