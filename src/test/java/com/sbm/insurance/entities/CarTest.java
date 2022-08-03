package com.sbm.insurance.entities;

import com.sbm.insurance.services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarTest {

    @Autowired
    private CarService carService;

    @Test
    public void createCar() {
        Car car = new Car("enes@gmail.com", 5, "Sedan", 10);

        carService.save(car);
    }
}