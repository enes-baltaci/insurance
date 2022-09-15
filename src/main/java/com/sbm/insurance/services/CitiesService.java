package com.sbm.insurance.services;

import com.sbm.insurance.entities.City;
import com.sbm.insurance.repositories.CitiesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    private final CitiesRepository citiesRepository;

    public CitiesService(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    public void save(City city) {
        citiesRepository.save(city);
    }

    public List<City> getAll() {
        return citiesRepository.findAll();
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public City getCityById(Long id) {
        return citiesRepository.findById(id).get();
    }
}