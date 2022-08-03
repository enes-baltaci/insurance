package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/create_account")
    public String createAccount(Model model) {
        Account account = new Account();
        model.addAttribute(account);

        return "account";
    }

    @PostMapping("/account_registrate")
    public String registrate(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/";
    }
}