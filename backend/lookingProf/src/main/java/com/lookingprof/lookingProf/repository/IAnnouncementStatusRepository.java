package com.lookingprof.lookingProf.repository;



import com.lookingprof.lookingProf.model.AnnouncementStatus;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IAnnouncementStatusRepository extends JpaRepository<AnnouncementStatus, Integer> {
    List<AnnouncementStatus> findByName(String name);
}