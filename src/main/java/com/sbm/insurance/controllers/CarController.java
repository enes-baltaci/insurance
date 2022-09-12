package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarBrandsService;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.CarTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CarBrandsService carBrandsService;

    @Autowired
    private CarTypesService carTypesService;

    @GetMapping("/car_insurance")
    public String car_insurance(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("brands", carBrandsService.getAll());
        model.addAttribute("types", carTypesService.getAll());
        return "car_insurance";
    }

    @PostMapping("/car_registration")
    public String car_registration(@Valid @ModelAttribute Car car, Model model) {

        carService.carRegistration(car);

        model.addAttribute("price", car.getProposal().getPrice());

        return "price";
    }
}