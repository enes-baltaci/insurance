package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarBrandsService;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.CarTypesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class CarController {

    private final CarService carService;

    private final AccountService accountService;

    private final CarBrandsService carBrandsService;

    private final CarTypesService carTypesService;

    public CarController(CarService carService, AccountService accountService, CarBrandsService carBrandsService, CarTypesService carTypesService) {
        this.carService = carService;
        this.accountService = accountService;
        this.carBrandsService = carBrandsService;
        this.carTypesService = carTypesService;
    }

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