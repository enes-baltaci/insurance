package com.sbm.insurance.services;

import com.sbm.insurance.entities.CarModelAge;
import com.sbm.insurance.repositories.CarModelAgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarModelAgeService {

    @Autowired
    private CarModelAgeRepository carModelAgeRepository;

    public void save(CarModelAge carModelAge) {
        carModelAgeRepository.save(carModelAge);
    }

    public List<CarModelAge> getAll() {
        return carModelAgeRepository.findAll();
    }

    public float getAgeMultiplier(int inputAge) {
        return carModelAgeRepository.getPriceMultiplier(inputAge);
    }
}