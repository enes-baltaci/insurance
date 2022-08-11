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

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    private boolean flag = false;

    @GetMapping("/create_account")
    public String createAccount(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        model.addAttribute("processName", "Create");
        model.addAttribute("action", "account_registration");

        return "account";
    }

    @PostMapping("/account_registration")
    public String registration(@Valid @ModelAttribute Account account) {

        try {
            accountService.save(account);
            flag = true;
            return "redirect:/info";
        }
        catch (Exception e) {
            flag = false;
            return "redirect:/info";
        }
    }

    @GetMapping("/info")
    public String info(Model model) {
        if (flag) {
            model.addAttribute("flag", true);
        }
        else {
            model.addAttribute("flag", false);
        }
        return "account_creation_info";
    }

    @GetMapping("/account_list")
    public String selectAccount(Model model) {
        model.addAttribute("accounts", accountService.getAll());
        return "account_list";
    }

    @GetMapping("/account_edit/{id}")
    public String sendAccount(@PathVariable("id") Long id, Model model) {

        Optional<Account> accountOptional = accountService.getById(id);

        if (accountOptional.isPresent()) {
            model.addAttribute("account", accountOptional.get());
            model.addAttribute("processName", "Update");
            model.addAttribute("action", "account_edit/" + accountOptional.get().getId());
            return "account";
        } else {
            return "id_error";
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

            if (account.getAge() != accountDatabase.getAge()) {
                accountDatabase.setAge(account.getAge());
            }

            accountService.save(accountDatabase);

            return "redirect:/";

        } else {
            return "id_error";
        }
    }

    @GetMapping("/account/delete/{id}")
    public String deleteAccount(@PathVariable Long id) {
        try {
            accountService.deleteAccount(id);
            return "redirect:/account_list";
        } catch (Exception e) {
            return "id_error";
        }
    }
}