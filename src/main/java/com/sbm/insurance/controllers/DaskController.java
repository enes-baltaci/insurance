package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class DaskController {

    @Autowired
    private DaskService daskService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CitiesService citiesService;

    @Autowired
    private DaskDamageStatusService daskDamageStatusService;

    @Autowired
    private DaskBuildingStyleService daskBuildingStyleService;

    @GetMapping("/dask_insurance")
    public String daskInsurance(Model model) {
        model.addAttribute("dask", new Dask());
        model.addAttribute("address", new Address());
        model.addAttribute("cities", citiesService.getAll());
        model.addAttribute("daskDamages", daskDamageStatusService.getAll());
        model.addAttribute("daskBuildings", daskBuildingStyleService.getAll());
        model.addAttribute("accounts", accountService.getAll());
        return "dask_insurance";
    }

    @PostMapping("/dask_registration")
    public String daskRegistration(@Valid @ModelAttribute Dask dask, @Valid @ModelAttribute Address address, Model model) {

        daskService.daskRegistration(dask, address);

        model.addAttribute("price", dask.getProposal().getPrice());

        return "price";
    }
}