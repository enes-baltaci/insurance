package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.ProposalService;
import com.sbm.insurance.services.TravelService;
import com.sbm.insurance.services.TravelTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
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

    @Autowired
    private TravelTypesService travelTypesService;

    @GetMapping("/travel_insurance")
    public String travelInsurance(Model model) {
        model.addAttribute("travel", new Travel());
        model.addAttribute("accounts", accountService.getAll());
        model.addAttribute("travelTypes", travelTypesService.getAll());
        return "travel_insurance";
    }

    @PostMapping("/travel_registration")
    public String travelRegistration(@Valid @ModelAttribute Travel travel, Model model) {

        float price = (travel.getTravelType().getPrice()) +
              ((travel.getDistance_km() / 1000) * travel.getTravelType().getDistanceMultiplier()) +
              (travel.getDays() * travel.getTravelType().getDayMultiplier());

        if (travel.getDistanceType().equalsIgnoreCase("Mile")) { // Convert it into kilometer
            travel.setDistance_km((float) (travel.getDistance_km() * 1.6));
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