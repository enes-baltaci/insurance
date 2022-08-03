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

    @PostMapping("/car_registrate")
    public String carRegistrate(@ModelAttribute Car car , Model model) {

        int price = 0;

        if (car.getModel().equalsIgnoreCase("SUV")) {

            price = 3000;

            if (car.getAge() < 2) {
                price += 2400;
            }
            else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 1800;
            }
            else {
                price += 1000;
            }
        }
        else if (car.getModel().equalsIgnoreCase("Sedan")) {

            price = 3600;

            if (car.getAge() < 2) {
                price += 2700;
            }
            else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 2400;
            }
            else {
                price += 1800;
            }
        }
        else {
            price = 2400;

            if (car.getAge() < 2) {
                price += 1500;
            }
            else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 1200;
            }
            else {
                price += 800;
            }
        }

        price -= car.getMemberYear() < 5 ? 0 : 250;

        car.setPrice(price);

        carService.save(car);

        model.addAttribute("price", price);

        return "price";
    }
}