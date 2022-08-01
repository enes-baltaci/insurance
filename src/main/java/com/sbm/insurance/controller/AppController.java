package com.sbm.insurance.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sbm.insurance.entity.Car;
import com.sbm.insurance.repository.CarRepository;

@Controller
public class AppController {

    @Autowired
    private CarRepository repo;
    
    @GetMapping("")
    public String hello (Model model) {
        model.addAttribute("message", "Welcome to Insurance");
        return "index";
    }

    @GetMapping("/insurance_page")
    public String insurance() {
        return "insurance_page";
    }

    @PostMapping("/submit")
    public String processRegistration (Car car) {
        repo.save(car);
        return "index";
    }
}