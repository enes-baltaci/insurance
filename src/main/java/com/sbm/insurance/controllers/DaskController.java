package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
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
public class DaskController {

    @Autowired
    private DaskService daskService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProposalService proposalService;

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

        float price = 2430;

        price *= address.getCity().getPriceMultiplier();

        price *= dask.getDaskBuildingStyle().getPriceMultiplier();

        if (dask.getArea() > 250) {
            price *= 3.5;
        } else if (dask.getArea() > 200) {
            price *= 3;
        } else if (dask.getArea() > 150) {
            price *= 2.5;
        } else if (dask.getArea() > 100) {
            price *= 2;
        } else {
            price *= 1.5;
        }

        price *= dask.getDaskDamageStatus().getPriceMultiplier();

        if (dask.getFloorNumber() > 50) {
            price *= 1.5;
        } else if (dask.getFloorNumber() > 40) {
            price *= 1.4;
        } else if (dask.getFloorNumber() > 30) {
            price *= 1.3;
        } else if (dask.getFloorNumber() > 20) {
            price *= 1.2;
        } else {
            price *= 1.1;
        }

        if (Calendar.getInstance().get(Calendar.YEAR) - dask.getBuildYear() > 100) {
            price *= 5;
        } else if (Calendar.getInstance().get(Calendar.YEAR) - dask.getBuildYear() > 75) {
            price *= 3.75;
        } else if (Calendar.getInstance().get(Calendar.YEAR) - dask.getBuildYear() > 50) {
            price *= 2.5;
        } else {
            price *= 1.25;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Dask")
                .build();

        proposalService.save(proposal);

        dask.setProposal(proposal);

        addressService.save(address);

        daskService.save(dask);

        address.setDask(dask);

        dask.setAddress(address);

        addressService.save(address);

        daskService.save(dask);

        model.addAttribute("price", price);

        return "price";
    }
}