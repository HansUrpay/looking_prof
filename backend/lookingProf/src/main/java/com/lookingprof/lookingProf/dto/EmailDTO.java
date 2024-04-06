package com.lookingprof.lookingProf.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    private String fromName;
    private String fromEmail;
    private String subject;
    private String text;

}
