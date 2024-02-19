package com.lookingprof.lookingProf.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int idCity;
    private String nameCity;
    @ManyToOne
    @JoinColumn(name="fk_province")
    private Province province;


}
