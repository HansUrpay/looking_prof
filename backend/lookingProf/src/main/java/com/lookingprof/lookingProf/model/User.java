package com.lookingprof.lookingProf.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.NumberFormat;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    private String firstName;
    @NotEmpty(message = "El apellido no puede estar vacío")
    private String lastName;
    @NotEmpty(message = "El nombre de usuario no puede estar vacío")
    private String userName;
    @Email(message = "Debe ser una dirección de correo electrónico válida")
    private String email;
    @NotEmpty(message = "La contraseña no puede estar vacía")
    private String password;

    //private Role idRole;
    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener 10 dígitos")
    private String phone;
    private String address;
    @NotEmpty(message = "Debe seleccionar un país")
    private String country;
    @NotEmpty(message = "Debe seleccionar una provincia")
    private String province;
    @NotEmpty(message = "Debe seleccionar una ciudad")
    private String city;
    private Integer qualification;
    //private Profession idProfession;

    //private String redes;

}
