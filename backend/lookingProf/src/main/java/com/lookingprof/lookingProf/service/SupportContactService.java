package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.dto.SupportContactDTO;
import com.lookingprof.lookingProf.model.Publication;
import com.lookingprof.lookingProf.model.SupportContact;
import com.lookingprof.lookingProf.repository.ISupportContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SupportContactService implements ISupportContactService {
    private final ISupportContactRepository supportContactRepository;


    public List<SupportContact> getAllSupportContact(){
        return supportContactRepository.findAll();
    }

    //get SupportContact by id
    public SupportContact findSupportContactById(Integer idSupportContact){
        return supportContactRepository.findById(idSupportContact).orElse(null);
    }

    //create SupportContact
    public void saveSupportContact(SupportContact supportContact){
        supportContactRepository.save(supportContact);
    }

    //delete SupportContact by id
    public void deleteSupportContact(Integer idSupportContact){
        supportContactRepository.deleteById(idSupportContact);
    }

    //edit SupportContact
    public void editSupportContact(SupportContact supportContact){
        this.saveSupportContact(supportContact);
    }

    @Override
    public Optional<List<SupportContactDTO>> getSupportContactDTO() {
        List<SupportContact> supportContactList = supportContactRepository.findAll();
        List<SupportContactDTO> supportContactDTOList = new ArrayList<>();
        if (supportContactList.isEmpty()){
            return Optional.empty();
        } else {
            supportContactList.forEach(supportContact -> {
                SupportContactDTO supportContactDTO = new SupportContactDTO(supportContact);
                supportContactDTOList.add(supportContactDTO);
            });
        }

        return Optional.of(supportContactDTOList);
    }

    @Override
    public SupportContactDTO getSupportContactDTOById(Integer idSupportContact) {
        SupportContactDTO supportContactDTO = new SupportContactDTO(supportContactRepository.findById(idSupportContact).get());
        return supportContactDTO;
    }


}
