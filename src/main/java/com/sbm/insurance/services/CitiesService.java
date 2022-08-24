package com.sbm.insurance.services;

import com.sbm.insurance.entities.Cities;
import com.sbm.insurance.repositories.CitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    @Autowired
    private CitiesRepository citiesRepository;

    public void save(Cities cities) {
        citiesRepository.save(cities);
    }

    public List<Cities> getAll() {
        return citiesRepository.findAll();
    }

    public Cities getCityById(Long id) {
        return citiesRepository.findById(id).get();
    }
}