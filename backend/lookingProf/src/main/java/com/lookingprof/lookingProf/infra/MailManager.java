/*
package com.lookingprof.lookingProf.infra;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

//en esta clase exponemos los metodos para enviar  correos
@Component //esto es para que se inyecte la dependencia
public class MailManager {

    JavaMailSender javaMailSender;

    public MailManager(JavaMailSender javaMailSender){
        this.javaMailSender=javaMailSender;
    }

    public void sendMessage(String email, String description){

        //la creacion de este objeto es para poder construir el mensaje
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //vamos a construir lo que vamos a enviar y enviarlo
        try {
            mimeMessage.setSubject("Prueba de enviar email con Spring Boot");
            //este helper es para decirle que el correo puede tener varias partes
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        } catch (MessagingException e){
            throw new RuntimeException(e);
        }

    }

}
*/