package com.lookingprof.lookingProf.service;


import com.lookingprof.lookingProf.model.AnnouncementStatus;
import com.lookingprof.lookingProf.repository.IAnnouncementStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor


public class AnnouncementStatusService implements IAnnouncementStatusService {


   private final IAnnouncementStatusRepository iAnnouncementStatusRepository;


    @Override
    public List<AnnouncementStatus> findByName(String name) {
        return iAnnouncementStatusRepository.findByName(name);
    }

    @Override
    public List<AnnouncementStatus> listAll() {
        return iAnnouncementStatusRepository.findAll();
    }

    public Optional<AnnouncementStatus> findById(Integer id) {
        return iAnnouncementStatusRepository.findById( id );
    }


    public AnnouncementStatus createAnnouncementStatus (AnnouncementStatus entity){
        try {
            return iAnnouncementStatusRepository.save(entity);
        }catch (Exception e){
            throw new RuntimeException("Error: creating AnnouncementStatus");
        }

    }

    public AnnouncementStatus updateAnnouncementStatus (Integer id, AnnouncementStatus entity){
        try {
            AnnouncementStatus existingEntity = iAnnouncementStatusRepository.findById(id).orElse(null);

            if (existingEntity != null) {
                existingEntity.setName(entity.getName());
                return iAnnouncementStatusRepository.save(existingEntity);
            } else {
                throw new RuntimeException("Error: AnnouncementStatus not found");
            }
        }catch (Exception e){
            throw new RuntimeException("Error: could not update");

        }

    }
    public HashMap<String, String> deleteAnnouncementStatus(Integer id) {
        try{
            HashMap<String, String> response = new HashMap<>();
            response.put("Message:", "AnnouncementStatus deleted succesfully");
            iAnnouncementStatusRepository.deleteById(id);
            return response;
        }catch (Exception e){
            throw new RuntimeException("Error: while delete AnnouncementStatus");
        }
    }

}
