package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.model.AnnouncementStatus;

import java.util.List;

public interface IAnnouncementStatusService {

     List<AnnouncementStatus> findByName(String name);

     List<AnnouncementStatus> listAll();

}
