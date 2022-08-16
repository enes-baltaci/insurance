package com.sbm.insurance.services;

import com.sbm.insurance.entities.CarBrands;
import com.sbm.insurance.repositories.CarBrandsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarBrandsService {

    @Autowired
    private CarBrandsRepository carBrandsRepository;

    public void save(CarBrands carBrands) {
        carBrandsRepository.save(carBrands);
    }

    public List<CarBrands> getAll() {
        return carBrandsRepository.findAll();
    }
}