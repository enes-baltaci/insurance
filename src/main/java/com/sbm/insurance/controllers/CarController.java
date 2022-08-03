package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/car_insurance")
    public String carInsurance(Model model) {
        Car car = new Car();
        model.addAttribute(car);
        return "car_insurance";
    }

    @PostMapping("registrate")
    public String registrate(@ModelAttribute Car car) {

        if (car.getModel().equalsIgnoreCase("SUV")) {

        }
        else if (car.getModel().equalsIgnoreCase("Sedan")) {

        }
        else {

        }

        carService.save(car);



        return "price";
    }
}