package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.AddressService;
import com.sbm.insurance.services.DaskService;
import com.sbm.insurance.services.ProposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

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

    @GetMapping("/dask_insurance")
    public String daskInsurance(Model model) {
        model.addAttribute("dask", new Dask());
        model.addAttribute("accounts", accountService.getAll());
        return "dask_insurance";
    }

    @GetMapping("/dask_insurance/address")
    public String daskInsuranceAddress(@Valid @ModelAttribute Dask dask, Model model) {

        daskService.save(dask);

        model.addAttribute("address", new Address());
        model.addAttribute("daskId", dask.getId());
        return "dask_address";
    }

    @PostMapping("/dask_registration/{id}")
    public String daskRegistration(@Valid @ModelAttribute Address address, @PathVariable Long id, Model model) {

        Optional<Dask> dask = daskService.getDaskById(id);

        if (!dask.isPresent()) {
            return "id_error";
        }

        float price = 2430;

        if (address.getCity().equalsIgnoreCase("İstanbul") ||
                address.getCity().equalsIgnoreCase("İzmir") ||
                address.getCity().equalsIgnoreCase("Ankara")) {
            price *= 2.2;
        }

        if (dask.get().getBuildingStyle().equalsIgnoreCase("Masonry")) {
            price *= 1.7;
        } else if (dask.get().getBuildingStyle().equalsIgnoreCase("Other")) {
            price *= 2.5;
        } else {
            price *= 1.2;
        }

        if (dask.get().getArea() > 250) {
            price *= 3.5;
        } else if (dask.get().getArea() > 200) {
            price *= 3;
        } else if (dask.get().getArea() > 150) {
            price *= 2.5;
        } else if (dask.get().getArea() > 100) {
            price *= 2;
        } else {
            price *= 1.5;
        }

        switch (dask.get().getDamageStatus()) {
            case 1:
                price += 250;
                break;
            case 2:
                price *= 1.4;
                break;
            case 3:
                price *= 1.7;
                break;
            case 4:
                price *= 2.5;
                break;
            case 5:
                price *= 5;
                break;
        }

        if (dask.get().getFloorNumber() > 50) {
            price *= 1.5;
        } else if (dask.get().getFloorNumber() > 40) {
            price *= 1.4;
        } else if (dask.get().getFloorNumber() > 30) {
            price *= 1.3;
        } else if (dask.get().getFloorNumber() > 20) {
            price *= 1.2;
        } else {
            price *= 1.1;
        }

        if (Calendar.getInstance().get(Calendar.YEAR) - dask.get().getBuildYear() > 100) {
            price *= 5;
        } else if (Calendar.getInstance().get(Calendar.YEAR) - dask.get().getBuildYear() > 75) {
            price *= 3.75;
        } else if (Calendar.getInstance().get(Calendar.YEAR) - dask.get().getBuildYear() > 50) {
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

        dask.get().setProposal(proposal);

        address.setDask(dask.get());
        addressService.save(address);

        dask.get().setAddress(address);
        daskService.save(dask.get());

        model.addAttribute("price", price);

        return "price";
    }
}