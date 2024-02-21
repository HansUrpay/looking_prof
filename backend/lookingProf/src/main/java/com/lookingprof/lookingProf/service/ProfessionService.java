package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.Profession;
import com.lookingprof.lookingProf.repository.IProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfessionService implements IProffesionService {

    @Autowired
    private IProfessionRepository professionRepository;

    @Override
    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }

    @Override
    public Profession findProfessionById(Integer idProfession) {
        return professionRepository.findById(idProfession).orElse(null);
    }

    @Override
    public void saveProfession(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public void deleteProfession(Integer idProfession) {
        professionRepository.deleteById(idProfession);
    }

    @Override
    public void editProfession(Profession profession) {
        this.saveProfession(profession);
    }
}
