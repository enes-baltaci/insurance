package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.AddressService;
import com.sbm.insurance.services.DaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class DaskController {

    @Autowired
    private DaskService daskService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AddressService addressService;

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
    public String daskRegistration(@Valid @ModelAttribute Address address, @PathVariable Long id) {

        Optional<Dask> dask = daskService.getDaskById(id);

        if (dask.isPresent()) {
            address.setDask(dask.get());
            addressService.save(address);
            dask.get().setAddress(address);

            daskService.save(dask.get());
        }

        return "redirect:/";
    }
}