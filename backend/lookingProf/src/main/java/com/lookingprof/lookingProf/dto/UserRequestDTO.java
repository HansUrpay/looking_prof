package com.lookingprof.lookingProf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequestDTO {
//aca van los campos para editar y crear el usuario
    private String phone;
    private Integer province;
    private String city;
    private Integer profession;
    private String description;
    //private MultipartFile image;

}
