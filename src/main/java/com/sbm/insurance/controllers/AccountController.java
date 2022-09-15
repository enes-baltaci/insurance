package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CitiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@Controller
public class AccountController {

    private final AccountService accountService;

    private final CitiesService citiesService;

    private boolean emailExist = true;
    private boolean updated = false;

    public AccountController(AccountService accountService, CitiesService citiesService) {
        this.accountService = accountService;
        this.citiesService = citiesService;
    }

    @GetMapping("/create_account")
    public String createAccount(Model model) {
        updated = false;
        model.addAttribute("account", new Account());
        model.addAttribute("cities", citiesService.getAll());
        model.addAttribute("processName", "Create");
        model.addAttribute("action", "account_registration");

        return "account";
    }

    @PostMapping("/account_registration")
    public String registration(@Valid @ModelAttribute Account account) {

        try {
            accountService.save(account);
            emailExist = false;
            return "redirect:/info/0";
        } catch (Exception e) {
            emailExist = true;
            return "redirect:/info/0";
        }
    }

    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") Long id, Model model) {
        if (emailExist) {
            model.addAttribute("flag", true);
            if (updated) {
                model.addAttribute("id", id);
                model.addAttribute("updated", true);
            }
        } else if (updated) {
            model.addAttribute("updated", true);
        } else {
            model.addAttribute("flag", false);
        }
        emailExist = true;
        return "account_info";
    }

    @GetMapping("/account_list")
    public String accountList(Model model) {
        model.addAttribute("accounts", accountService.getAll());
        return "account_list";
    }

    @GetMapping("/account_edit/{id}")
    public String sendAccount(@PathVariable("id") Long id, Model model) {

        Optional<Account> accountOptional = accountService.getById(id);

        if (accountOptional.isPresent()) {
            model.addAttribute("account", accountOptional.get());
            model.addAttribute("processName", "Update");
            model.addAttribute("cities", citiesService.getAll());
            model.addAttribute("action", "account_edit/" + accountOptional.get().getId());
            updated = true;
            return "account";
        } else {
            return "id_error";
        }
    }

    @PostMapping("/account_edit/{id}")
    public String editAccount(@PathVariable("id") Long id, Account account) {

        if (accountService.getById(id).isEmpty()) {
            return "id_error";
        }

        Account accountDatabase = accountService.getById(id).get();

        if (!Objects.equals(account.getIdentity(), accountDatabase.getIdentity())) {
            accountDatabase.setIdentity(account.getIdentity());
        }

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

        if (!account.getCity().getCityName().equalsIgnoreCase(accountDatabase.getCity().getCityName())) {
            accountDatabase.setCity(account.getCity());
        }

        try {
            accountService.save(account);
            emailExist = false;
            return "redirect:/info/" + accountDatabase.getId();
        } catch (Exception e) {
            emailExist = true;
            return "redirect:/info/" + accountDatabase.getId();
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