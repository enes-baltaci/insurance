package com.sbm.insurance.controllers;

import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListInsuranceController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private CarService carService;

    @GetMapping("/list_insurances")
    public String listInsurances(Model model) {
        model.addAttribute("cars", carService.getAll());
        model.addAttribute("travels", travelService.getAll());
        return "insurances";
    }
}
