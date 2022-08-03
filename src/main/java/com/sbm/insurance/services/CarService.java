package com.sbm.insurance.services;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public Car save(Car car) {
        return carRepository.save(car);
    }
}