package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/car_insurance")
    public String carInsurance(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("accounts", accountService.getAll());
        return "car_insurance";
    }

    @PostMapping("/car_registration")
    public String carRegistration(@ModelAttribute Car car, Model model) {

        int price;

        if (car.getModel().equalsIgnoreCase("SUV")) {

            price = 3000;

            if (car.getAge() < 2) {
                price += 2400;
            } else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 1800;
            } else {
                price += 1000;
            }
        } else if (car.getModel().equalsIgnoreCase("Sedan")) {

            price = 3600;

            if (car.getAge() < 2) {
                price += 2700;
            } else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 2400;
            } else {
                price += 1800;
            }
        } else {
            price = 2400;

            if (car.getAge() < 2) {
                price += 1500;
            } else if (car.getAge() > 2 && car.getAge() < 6) {
                price += 1200;
            } else {
                price += 800;
            }
        }

        carService.save(car);

        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Proposal proposal = Proposal.builder()
                .account(car.getAccount())
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Car")
                .foreign_id(car.getId())
                .build();

        proposalService.save(proposal);

        model.addAttribute("price", price);

        return "price";
    }
}