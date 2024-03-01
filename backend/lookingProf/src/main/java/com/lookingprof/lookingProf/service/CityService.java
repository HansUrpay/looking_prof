package com.lookingprof.lookingProf.service;

import com.lookingprof.lookingProf.dto.CityDTO;
import com.lookingprof.lookingProf.model.City;
import com.lookingprof.lookingProf.repository.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CityService implements ICityService{

    @Autowired
    private ICityRepository cityRepository;
    @Override
    public Optional<List<CityDTO>> getAllCities() {
        List<City> cityList = cityRepository.findAll();
        List<CityDTO> listCityDTO = new ArrayList<>();
        if(cityList.isEmpty()){
            return Optional.empty();
        } else {
             cityList.forEach (city -> {
                CityDTO cityDTO = new CityDTO(city);
                listCityDTO.add(cityDTO);
            } );
        }
        return Optional.of(listCityDTO);
    }

    @Override
    public City getCityById(Integer idCity) {
        return cityRepository.findById(idCity).orElse(null);
    }

    @Override
    public CityDTO getCityDTOById(Integer idCity) {
        CityDTO cityDTO = new CityDTO(cityRepository.findById(idCity).get());
        return cityDTO;
    }

    @Override
    public City getCityByName(String city) {
        return cityRepository.findByNameCity(city);
    }
}
