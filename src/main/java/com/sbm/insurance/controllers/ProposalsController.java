package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProposalsController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private CarService carService;

    @GetMapping("/proposals")
    public String listInsurances(Model model) {
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("travels", travelService.getAll());
        return "proposals";
    }

    @PostMapping("/proposals/car/{id}")
    public String accept(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.getById(id);

        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();

            car.setStatus(true);

            carService.save(car);
        }

        return "redirect:/proposals";
    }
}
