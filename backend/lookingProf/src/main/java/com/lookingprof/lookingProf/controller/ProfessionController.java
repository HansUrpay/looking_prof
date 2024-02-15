package com.lookingprof.lookingProf.controller;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.service.IProffesionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profession")
public class ProfessionController {

    @Autowired
    private IProffesionService proffesionService;

    //get all professionals
    @GetMapping("/get")
    public List<Profession> getAllProfessionals(){
        return proffesionService.getAllProfessions();
    }

    //find professional by id
    @GetMapping("/get/{idProfession}")
    public Profession findProfession(@PathVariable Integer idProfession){
        return proffesionService.findProfessionById(idProfession);
    }
    //create profession
    @PostMapping("/create")
    public String createProfession (@RequestBody Profession profession){
        proffesionService.saveProfession(profession);
        return "Created Profession";
    }

    //delete profession
    @DeleteMapping("/delete/{idProfession}")
    public String deleteProfession (@PathVariable Integer idProfession){
        proffesionService.deleteProfession(idProfession);
        return "Deleted Profession";
    }

    //edit profession
    @PutMapping("/edit")
    public Profession editProfession(@RequestBody Profession profession){
        proffesionService.editProfession(profession);
        return proffesionService.findProfessionById(profession.getIdProfession());
    }
}
