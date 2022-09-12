package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private CarBrandsService carBrandsService;

    @Autowired
    private CarTypesService carTypesService;

    @Autowired
    private CarModelAgeService carModelAgeService;

    @GetMapping("/car_insurance")
    public String carInsurance(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("brands", carBrandsService.getAll());
        model.addAttribute("types", carTypesService.getAll());
        return "car_insurance";
    }

    @PostMapping("/car_registration")
    public String carRegistration(@Valid @ModelAttribute Car car, Model model) {

        float price = 1125;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        price *= car.getBrand().getCarBrandMultiplier();

        price *= carModelAgeService.getAgeMultiplier(Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear());

        price += (price * car.getModel().getCarTypeMultiplier());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Car")
                .build();

        proposalService.save(proposal);

        car.setProposal(proposal);

        carService.save(car);

        model.addAttribute("price", price);

        return "price";
    }
}