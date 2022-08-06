package com.sbm.insurance.services;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }
}