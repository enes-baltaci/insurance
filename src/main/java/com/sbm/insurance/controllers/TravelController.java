package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.TravelService;
import com.sbm.insurance.services.TravelTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TravelController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TravelTypesService travelTypesService;

    @GetMapping("/travel_insurance")
    public String travel_insurance(Model model) {
        model.addAttribute("travel", new Travel());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("travelTypes", travelTypesService.getAll());
        return "travel_insurance";
    }

    @PostMapping("/travel_registration")
    public String travel_registration(@Valid @ModelAttribute Travel travel, Model model) {

        travelService.travelRegistration(travel);

        model.addAttribute("price", travel.getProposal().getPrice());

        return "price";
    }
}