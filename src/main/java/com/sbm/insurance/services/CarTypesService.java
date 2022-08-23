package com.sbm.insurance.services;

import com.sbm.insurance.entities.CarTypes;
import com.sbm.insurance.repositories.CarTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypesService {

    @Autowired
    private CarTypesRepository carTypesRepository;

    public void save(CarTypes carTypes) {
        carTypesRepository.save(carTypes);
    }

    public List<CarTypes> getAll() {
        return carTypesRepository.findAll();
    }
}