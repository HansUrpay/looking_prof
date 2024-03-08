package com.lookingprof.lookingProf.dto;

import com.lookingprof.lookingProf.model.SupportContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportContactDTO {

    private Integer idSuportContact;
    private String email;
    private String asunt;
    private String description;

    public SupportContactDTO (SupportContact supportContact){
        this.idSuportContact=supportContact.getIdSuportContact();
        this.email=supportContact.getEmail();
        this.asunt=supportContact.getAsunt();
        this.description=supportContact.getDescription();
    }

}
