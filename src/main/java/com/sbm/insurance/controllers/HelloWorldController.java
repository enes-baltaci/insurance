package com.sbm.insurance.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    
    @GetMapping("")
    public String hello (Model model) {
        model.addAttribute("message", "Welcome to Insurance");
        return "index";
    }

    @GetMapping("/insurance_page")
    public String insurance() {
        return "insurance_page";
    }
}