package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.dto.CityDTO;
import com.lookingprof.lookingProf.model.City;
import com.lookingprof.lookingProf.model.Province;

import java.util.List;
import java.util.Optional;

public interface ICityService {

    //get city
    public Optional<List<CityDTO>> getAllCities();

    //get city by id
    public City getCityById(Integer idCity);

    //get cityDTO by id
    public CityDTO getCityDTOById(Integer idCity);

}
