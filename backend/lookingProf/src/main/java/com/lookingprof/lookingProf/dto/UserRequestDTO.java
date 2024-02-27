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

    private Integer idUser;
    private String lastName;
    private String firstName;
    private String email;
    private String phone;
    private String address;
    private String country;
    private Province province;
    private City city;
    private Integer qualification;
    private String imageUrl;
    private Profession profession;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String description;
    private List<Comment> commentsSubmitted;
    private List<Comment> commentsReceived;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private String title;
    private Boolean isActive;
}
