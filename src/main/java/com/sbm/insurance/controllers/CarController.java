package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarBrandsService;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.ProposalService;
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

    @GetMapping("/car_insurance")
    public String carInsurance(Model model) {
        model.addAttribute("car", new Car());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("brands", carBrandsService.getAll());
        return "car_insurance";
    }

    @PostMapping("/car_registration")
    public String carRegistration(@Valid @ModelAttribute Car car, Model model) {

        float price = 1125;

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        if (car.getBrand().getCarBrand().equalsIgnoreCase("Mercedes-Benz") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("BMW") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("Audi")) {

            price *= 3;

        } else if (car.getBrand().getCarBrand().equalsIgnoreCase("Volkswagen") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("Nissan") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("Mini Cooper")) {

            price *= 2;

        } else if (car.getBrand().getCarBrand().equalsIgnoreCase("Peugeot") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("Skoda") ||
                car.getBrand().getCarBrand().equalsIgnoreCase("Kia")) {

            price *= 1.5;

        } else {
            price *= 1.25;
        }

        if (Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear() == 0) {
            price *= 2;
        }
        else if (Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear() < 3) {
            price *= 1.75;
        }
        else if (Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear() < 5) {
            price *= 1.5;
        }
        else {
            price *= 1.25;
        }

        if (car.getType().equalsIgnoreCase("SUV")) {
            price += (price * (15 / 100));
        } else if (car.getType().equalsIgnoreCase("Sedan")) {
            price += (price * (1 / 5));
        } else {
            price += (price * (1 / 10));
        }

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