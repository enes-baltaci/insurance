package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.DaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class DaskController {

    @Autowired
    private DaskService daskService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/dask_insurance/address")
    public String daskInsuranceAddress(Model model) {
        model.addAttribute("address", new Address());
        return "dask_address";
    }

    @GetMapping("/dask_insurance")
    public String daskInsurance(@ModelAttribute Address address, Model model) {

        Dask dask = new Dask();

        dask.setAddress(address);

        model.addAttribute("dask", dask);
        model.addAttribute("accounts", accountService.getAll());
        return "dask_insurance";
    }
}