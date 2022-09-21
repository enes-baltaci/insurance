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
import java.util.Optional;

@Controller
public class AccountController {

    private final AccountService accountService;

    private final CitiesService citiesService;

    public AccountController(AccountService accountService, CitiesService citiesService) {
        this.accountService = accountService;
        this.citiesService = citiesService;
    }

    @GetMapping("/create_account")
    public String registration(Model model) {
        model.addAttribute("account", new Account());
        model.addAttribute("cities", citiesService.getAll());
        model.addAttribute("processName", "Create");
        model.addAttribute("action", "account_registration");

        return "account";
    }

    @PostMapping("/account_registration")
    public String createAccount(@Valid @ModelAttribute Account account) {

        try {
            accountService.save(account);
            return "redirect:/info";
        } catch (Exception e) {
            return "redirect:/emailExist";
        }
    }

    @GetMapping("/account_edit/{id}")
    public String sendAccount(@PathVariable("id") Long id, Model model) {

        Optional<Account> accountOptional = accountService.getById(id);

        if (accountOptional.isPresent()) {
            model.addAttribute("account", accountOptional.get());
            model.addAttribute("processName", "Update");
            model.addAttribute("cities", citiesService.getAll());
            model.addAttribute("action", "account_edit/" + accountOptional.get().getId());
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

        accountDatabase.setIdentity(account.getIdentity());

        accountDatabase.setName(account.getName());

        accountDatabase.setSurname(account.getSurname());

        accountDatabase.setEmail(account.getEmail());

        accountDatabase.setAge(account.getAge());

        accountDatabase.setCity(account.getCity());

        try {
            accountService.save(account);
            return "redirect:/info/update";
        } catch (Exception e) {
            return "redirect:/emailExist/update/" + accountDatabase.getId();
        }
    }

    @GetMapping("/account_list")
    public String accountList(Model model) {
        model.addAttribute("accounts", accountService.getAll());
        return "account_list";
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

    @GetMapping("/info")
    public String submitInfoCreate() {
        return "account_info";
    }

    @GetMapping("/info/update")
    public String submitInfoUpdate(Model model) {
        model.addAttribute("updated", true);
        return "account_info";
    }

    @GetMapping("/emailExist")
    public String emailExist(Model model) {
        model.addAttribute("flag", true);
        return "account_info";
    }

    @GetMapping("/emailExist/update/{id}")
    public String emailExistUpdated( @PathVariable("id") String id, Model model) {
        model.addAttribute("flag", true);
        model.addAttribute("updated", true);
        model.addAttribute("id", id);
        return "account_info";
    }
}