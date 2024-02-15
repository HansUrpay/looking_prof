package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;

import java.util.List;

public interface IProffesionService {

    //get profession
    public List<Profession> getAllProfessions();

    //get proffesion by id
    public Profession findProfessionById(Integer idProfession);

    //create profession
    public void saveProfession(Profession profession);

    //delete profession
    public void deleteProfession(Integer idProfession);

    //edit profession
    public void editProfession (Profession profession);


}
