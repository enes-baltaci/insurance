package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.ProposalService;
import com.sbm.insurance.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProposalsController {

    @Autowired
    private TravelService travelService;

    @Autowired
    private CarService carService;

    @Autowired
    private ProposalService proposalService;

    @GetMapping("/proposals")
    public String listProposals(Model model) {
        model.addAttribute("proposals", proposalService.getAll());
        model.addAttribute("accepted", false);
        model.addAttribute("title", "Proposals");
        model.addAttribute("link", "proposals/accepted");
        model.addAttribute("linkName", "Accepted Proposals");
        return "proposals";
    }

    @GetMapping("/proposals/accepted")
    public String listAcceptedProposals(Model model) {
        model.addAttribute("proposals", proposalService.getAll());
        model.addAttribute("accepted", true);
        model.addAttribute("title", "Accepted Proposals");
        model.addAttribute("link", "proposals");
        model.addAttribute("linkName", "Proposals");
        return "proposals";
    }

    @GetMapping("/proposal/details/travel/{id}")
    public String travelDetails(@PathVariable Long id, Model model) {
        Optional<Travel> optionalTravel = travelService.getById(id);

        if (optionalTravel.isPresent()) {
            model.addAttribute("travel", optionalTravel.get());
            return "travel_details";
        }
        else {
            return "id_error";
        }
    }

    @GetMapping("/proposal/details/car/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Optional<Car> optionalCar = carService.getById(id);

        if (optionalCar.isPresent()) {
            model.addAttribute("car", optionalCar.get());
            return "car_details";
        }
        else {
            return "id_error";
        }
    }

    @PostMapping("/proposals/accept/{id}")
    public String accept(@PathVariable Long id) {
        Optional<Proposal> optionalProposal = proposalService.getById(id);

        if (optionalProposal.isPresent()) {

            if (!optionalProposal.get().isStatus()) {
                proposalService.updateStatusById(optionalProposal.get().getId());
            }
            return "redirect:/proposals";
        }
        else {
            return "id_error";
        }
    }
}