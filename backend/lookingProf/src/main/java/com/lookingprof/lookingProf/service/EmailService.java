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


    public void sendSimpleMessage(String fromEmail, String to, String fromName, String subject, String text){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromName + " <" +fromEmail+ " >");
        message.setTo(to);
        message.setSubject(subject);
        message.setText("Usuario: " +fromName+ "\n"+  "Correo: " +fromEmail+ "\n"+ "Asunto: " +subject+ "\n"+ "Mensaje: " +text);
        javaMailSender.send(message);
    }

}
