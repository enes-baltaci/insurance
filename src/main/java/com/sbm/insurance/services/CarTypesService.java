package com.sbm.insurance.services;

import com.sbm.insurance.entities.CarModel;
import com.sbm.insurance.repositories.CarTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarTypesService {

    private final CarTypesRepository carTypesRepository;

    public CarTypesService(CarTypesRepository carTypesRepository) {
        this.carTypesRepository = carTypesRepository;
    }

    public void save(CarModel carModel) {
        carTypesRepository.save(carModel);
    }

    public List<CarModel> getAll() {
        return carTypesRepository.findAll();
    }
}