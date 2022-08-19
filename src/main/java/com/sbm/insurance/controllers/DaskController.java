package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.DaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DaskController {

    @Autowired
    private DaskService daskService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/dask_insurance")
    public String daskInsurance(Model model) {
        model.addAttribute("dask", new Dask());
        model.addAttribute("accounts", accountService.getAll());
        return "dask_insurance";
    }
}