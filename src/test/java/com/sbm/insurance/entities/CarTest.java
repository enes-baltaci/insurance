package com.sbm.insurance.entities;

import com.sbm.insurance.services.CarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CarTest {

    @Autowired
    private CarService carService;

    @Test
    public void createCar() {
        Car car = new Car(5, "Sedan");

        carService.save(car);
    }
}