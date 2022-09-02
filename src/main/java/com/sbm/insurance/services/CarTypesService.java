package com.sbm.insurance.services;

import com.sbm.insurance.entities.CarModel;
import com.sbm.insurance.repositories.CarTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypesService {

    @Autowired
    private CarTypesRepository carTypesRepository;

    public void save(CarModel carModel) {
        carTypesRepository.save(carModel);
    }

    public List<CarModel> getAll() {
        return carTypesRepository.findAll();
    }
}