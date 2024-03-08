package com.lookingprof.lookingProf.service;


import com.lookingprof.lookingProf.dto.SupportContactDTO;
import com.lookingprof.lookingProf.model.SupportContact;

import java.util.List;
import java.util.Optional;

public interface ISupportContactService {
    public List<SupportContact> getAllSupportContact();

    //get publication by id
    public SupportContact findSupportContactById(Integer idSupportContact);

    //create publication
    public void saveSupportContact(SupportContact supportContact);

    //delete publication by id
    public void deleteSupportContact(Integer idSupportContact);

    //edit publication
    public void editSupportContact(SupportContact supportContact);

    public Optional<List<SupportContactDTO>> getSupportContactDTO();

    public SupportContactDTO getSupportContactDTOById(Integer idSupportContact);
}

