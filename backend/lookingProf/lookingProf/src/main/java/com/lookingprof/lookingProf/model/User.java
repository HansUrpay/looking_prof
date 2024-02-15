package com.lookingprof.lookingProf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    //private Role idRole;
    private String phone;
    private String address;
    private String country;
    private String province;
    private String city;
    private Integer qualification;
    //private Profession idProfession;

    //private String redes;

}
