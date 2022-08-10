package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.ProposalService;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TravelController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/travel_insurance")
    public String travelInsurance(Model model) {
        model.addAttribute("travel", new Travel());
        model.addAttribute("accounts", accountService.getAll());
        return "travel_insurance";
    }

    @PostMapping("/travel_registration")
    public String travelRegistration(@ModelAttribute Travel travel, Model model) {

        int price;

        if (travel.getType().equalsIgnoreCase("Flight")) {

            price = 6500;

            price += (travel.getDistance() / 1000) * 320;

            price += travel.getDays() * 50;

        } else if (travel.getType().equalsIgnoreCase("Bus")) {

            price = 4250;

            price += (travel.getDistance() / 1000) * 120;

            price += travel.getDays() * 25;

        } else {

            price = 7000;

            price += (travel.getDistance() / 1000) * 340;

            price += travel.getDays() * 60;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Travel")
                .build();

        proposalService.save(proposal);

        travel.setProposal(proposal);

        travelService.save(travel);

        model.addAttribute("price", price);

        return "price";
    }
}