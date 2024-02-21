package com.lookingprof.lookingProf.controller;


import com.lookingprof.lookingProf.model.AnnouncementStatus;
import com.lookingprof.lookingProf.service.AnnouncementStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/announcementStatus")
@RequiredArgsConstructor


public class AnnouncementStatusController {

    private final AnnouncementStatusService announcementStatusService;


    @GetMapping()
    public ResponseEntity<List<AnnouncementStatus>> getAllAnnouncementStatusService() {
        try{

            List<AnnouncementStatus> AnnouncementList = announcementStatusService.listAll();
            return ResponseEntity.ok(AnnouncementList);

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnnouncementStatus> getAnnouncementStatusServiceById(@PathVariable Integer id){
        try{

            Optional<AnnouncementStatus> Announcement = announcementStatusService.findById(id);
            return Announcement.map(value -> ResponseEntity.ok().body(value)).orElseGet( () -> ResponseEntity.notFound().build());

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<AnnouncementStatus>> getAnnouncementStatusServiceByName(@PathVariable String name){
        try{

            List<AnnouncementStatus> AnnouncementList = announcementStatusService.findByName(name);
            return ResponseEntity.ok(AnnouncementList);

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PostMapping()
    public ResponseEntity<AnnouncementStatus> createAnnouncementStatus(@RequestBody AnnouncementStatus entity){
        try {

            AnnouncementStatus createAnnouncement = announcementStatusService.createAnnouncementStatus(entity);
            return new ResponseEntity<>(createAnnouncement, HttpStatus.CREATED);

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnnouncementStatus> updateAnnouncementStatus(@PathVariable Integer id, @RequestBody AnnouncementStatus entity){
        try{

            AnnouncementStatus updatedAnnouncement = announcementStatusService.updateAnnouncementStatus(id, entity);
            if (updatedAnnouncement!=null) return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
            else return ResponseEntity.notFound().build();

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HashMap<String, String>> deleteAnnouncementStatus(@PathVariable Integer id){
        try{

            HashMap<String, String> response = announcementStatusService.deleteAnnouncementStatus(id);
            return new ResponseEntity<>(response, HttpStatus.OK);

        }catch (Exception e){

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }





}
