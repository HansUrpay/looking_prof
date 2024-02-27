package com.lookingprof.lookingProf.dto;

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
}
