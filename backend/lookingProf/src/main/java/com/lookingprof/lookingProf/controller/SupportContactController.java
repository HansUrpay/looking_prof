package com.lookingprof.lookingProf.controller;

import com.lookingprof.lookingProf.dto.EmailDTO;
import com.lookingprof.lookingProf.dto.SupportContactDTO;
import com.lookingprof.lookingProf.model.SupportContact;
import com.lookingprof.lookingProf.service.EmailService;
import com.lookingprof.lookingProf.service.SupportContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
@RestController
@RequiredArgsConstructor
@RequestMapping("/supportContact")
public class SupportContactController {

    private final SupportContactService supportContactService;

    @Autowired
    private EmailService emailService;

    @Value("${spring.mail.username}")
    private String to;

    @GetMapping("/get")
    public List<SupportContact> getAllSupportContact(){
        return supportContactService.getAllSupportContact();
    }
    @GetMapping("/get/{idSupportContact}")
    public SupportContact getSupportContactById( @PathVariable Integer idSupportContact){
        return supportContactService.findSupportContactById(idSupportContact);
    }

    @PostMapping("/create")
    public String createSupportContact( @RequestBody SupportContact supportContact){
        supportContactService.saveSupportContact(supportContact);
        return "Create SupportContact";
    }

    @DeleteMapping("/delete/{idSupportContact}")
    public String deleteSupportContact(@PathVariable Integer idSupportContact){
        supportContactService.deleteSupportContact(idSupportContact);
        return "Delete SupportContact";
    }

    @PutMapping("/edit")
    public SupportContact editSupportContact(@RequestBody SupportContact supportContact){
        supportContactService.editSupportContact(supportContact);
        return supportContactService.findSupportContactById(supportContact.getIdSuportContact());
    }

    @GetMapping("/getDTO")
    public ResponseEntity<?> getAllSupportContactDTO(){
        Optional<List<SupportContactDTO>> listOptional = supportContactService.getSupportContactDTO();
        if(listOptional.isPresent()){
            return ResponseEntity.ok(listOptional.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No hay resultados para mostrar");
        }
    }

    @GetMapping("/getDTO/{idSupportContact}")
    public SupportContactDTO findBySupportContactoDTO(@PathVariable Integer idSupportContact){
        SupportContactDTO supportContactDTO = supportContactService.getSupportContactDTOById(idSupportContact);
        return supportContactDTO;
    }


    @Value("${spring.mail.username}")
    private String destination;

    @PostMapping("/send")
    public String sendEmail(@RequestBody EmailDTO emailDTO){
        emailService.sendSimpleMessage(emailDTO.getFromEmail(), destination, emailDTO.getFromName(), emailDTO.getSubject(), emailDTO.getText() );
        return "Email enviado correctamente";
    }

}
