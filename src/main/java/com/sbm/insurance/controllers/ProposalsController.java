package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.Optional;

@Controller
public class ProposalsController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private CarService carService;

    @GetMapping("/proposals")
    public String listProposals(Model model) {
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("travels", travelService.getAll());
        model.addAttribute("accepted", false);
        model.addAttribute("title", "Proposals");
        model.addAttribute("carTitle", "Car Insurance Proposals");
        model.addAttribute("traveltitle", "Travel Insurance Proposals");
        return "proposals";
    }

    @GetMapping("/proposals/accepted")
    public String listAcceptedProposals(Model model) {
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("travels", travelService.getAll());
        model.addAttribute("accepted", true);
        model.addAttribute("title", "Accepted Proposals");
        model.addAttribute("carTitle", "Car Insurances");
        model.addAttribute("traveltitle", "Travel Insurances");
        return "proposals";
    }

    @PostMapping("/proposals/car/{id}")
    public String acceptCar(@PathVariable Long id) {
        Optional<Car> optionalCar = carService.getById(id);

        if (optionalCar.isPresent()) {

            if (!optionalCar.get().isStatus()) {

                carService.updateCarStatusById(optionalCar.get().getId());

            }

            return "redirect:/proposals";
        }
        else {
            return "error";
        }
    }

    @PostMapping("/proposals/travel/{id}")
    public String acceptTravel(@PathVariable Long id) {
        Optional<Travel> optionalTravel = travelService.getById(id);

        if (optionalTravel.isPresent()) {

            if (!optionalTravel.get().isStatus()) {
                travelService.updateTravelStatusById(optionalTravel.get().getId());
            }

            return "redirect:/proposals";
        }
        else {
            return "error";
        }
    }
}
