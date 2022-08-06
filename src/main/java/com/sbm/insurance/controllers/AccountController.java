package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/create_account")
    public String createAccount(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("processName", "Create");
        model.addAttribute("action", "account_registrate");

        return "account";
    }

    @PostMapping("/account_registrate")
    public String registrate(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/";
    }

    @GetMapping("/account_select")
    public String selectAccount(Model model) {
        model.addAttribute("accounts", accountService.getAll());
        return "account_select";
    }

    @GetMapping("/account_edit/{id}")
    public String sendAccount(@PathVariable("id") Long id, Model model) {

        Optional<Account> accountOptional = accountService.getById(id);

        if (accountOptional.isPresent()) {
            model.addAttribute("account", accountOptional.get());
            model.addAttribute("processName", "Update");
            model.addAttribute("action", "account_edit/" + accountOptional.get().getId());
            return "account";
        }
        else {
            return "error";
        }
    }

    @PostMapping("/account_edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Account account) {

        if (accountService.getById(id).isPresent()) {

            Account accountDatabase = accountService.getById(id).get();

            if (!account.getName().equalsIgnoreCase(accountDatabase.getName())) {
                accountDatabase.setName(account.getName());
            }

            if (!account.getSurname().equalsIgnoreCase(accountDatabase.getSurname())) {
                accountDatabase.setSurname(account.getSurname());
            }

            if (!account.getEmail().equalsIgnoreCase(accountDatabase.getEmail())) {
                accountDatabase.setEmail(account.getEmail());
            }

            if (account.getMemberYear() != accountDatabase.getMemberYear()) {
                accountDatabase.setMemberYear(account.getMemberYear());
            }

            accountService.save(accountDatabase);

            return "redirect:/";

        }
        else {
            return "error";
        }
    }
}