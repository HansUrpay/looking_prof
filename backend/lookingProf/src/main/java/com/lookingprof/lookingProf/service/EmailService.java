package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.dto.EmailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    public void sendSimpleMessage(String to, EmailDTO emailDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(emailDTO.getFromName() + " <" + emailDTO.getFromEmail() + " >");
        message.setTo(to);
        message.setSubject(emailDTO.getSubject());
        message.setText("Usuario: " + emailDTO.getFromName() + "\n"+  "Correo: " + emailDTO.getFromEmail() + "\n"+ "Asunto: " + emailDTO.getSubject() + "\n"+ "Mensaje: " + emailDTO.getText());
        javaMailSender.send(message);
    }

}
