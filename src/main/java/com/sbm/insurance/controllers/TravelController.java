package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping("/travel_insurance")
    public String travelInsurance(Model model) {
        Travel travel = new Travel();
        model.addAttribute(travel);
        return "travel_insurance";
    }

    @PostMapping("/travel_registrate")
    public String travelRegistrate(@ModelAttribute Travel travel, Model model) {

        int price;

        if (travel.getType().equalsIgnoreCase("Flight")) {

            price = 6500;

            price += (travel.getDistance() / 1000) * 320;

            price += travel.getDays() * 50;

        } else if (travel.getType().equalsIgnoreCase("Bus")) {

            price = 4250;

            price += (travel.getDistance() / 1000) * 120;

            price += travel.getDays() * 25;

        } else {

            price = 7000;

            price += (travel.getDistance() / 1000) * 340;

            price += travel.getDays() * 60;
        }

        travel.setPrice(price);

        travelService.save(travel);

        model.addAttribute("price", price);

        return "price";
    }
}