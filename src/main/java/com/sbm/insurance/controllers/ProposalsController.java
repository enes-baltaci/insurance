package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.*;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.DaskService;
import com.sbm.insurance.services.ProposalService;
import com.sbm.insurance.services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;
import java.util.Optional;

@Controller
public class ProposalsController {

    private final TravelService travelService;

    private final CarService carService;

    private final DaskService daskService;

    private final ProposalService proposalService;

    public ProposalsController(TravelService travelService,
                               CarService carService,
                               DaskService daskService,
                               ProposalService proposalService) {
        this.travelService = travelService;
        this.carService = carService;
        this.daskService = daskService;
        this.proposalService = proposalService;
    }

    @GetMapping("/proposals")
    public String listProposals(Model model) {
        model.addAttribute("proposals", proposalService.getAll());
        model.addAttribute("accepted", false);
        model.addAttribute("title", "Proposals");
        model.addAttribute("link", "/proposals/account/");
        return "proposals";
    }

    @GetMapping("/proposals/account/{id}")
    public String listProposalsByAccount(@PathVariable("id") Long id, Model model) {
        model.addAttribute("proposals", proposalService.proposalsByAccountId(id));
        model.addAttribute("accepted", false);
        model.addAttribute("title", "Proposals");
        model.addAttribute("link", "/proposals/account/");
        return "proposals";
    }

    @GetMapping("/proposals/accepted")
    public String listAcceptedProposals(Model model) {
        model.addAttribute("proposals", proposalService.getAll());
        model.addAttribute("accepted", true);
        model.addAttribute("title", "Accepted Proposals");
        model.addAttribute("link", "/proposals/accepted/account/");
        return "proposals";
    }

    @GetMapping("/proposals/accepted/account/{id}")
    public String listAcceptedProposalsByAccount(@PathVariable("id") Long id, Model model) {
        model.addAttribute("proposals", proposalService.proposalsByAccountId(id));
        model.addAttribute("accepted", true);
        model.addAttribute("title", "Accepted Proposals");
        model.addAttribute("link", "/proposals/accepted/account/");
        return "proposals";
    }

    @GetMapping("/proposal/details/travel/{id}")
    public String travelDetails(@PathVariable Long id, Model model) {
        Optional<Travel> optionalTravel = travelService.getById(id);

        if (optionalTravel.isPresent()) {
            model.addAttribute("travel", optionalTravel.get());
            model.addAttribute("dto", new BooleanDTO());
            return "travel_details";
        } else {
            return "id_error";
        }
    }

    @GetMapping("/proposal/details/car/{id}")
    public String carDetails(@PathVariable Long id, Model model) {
        Optional<Car> optionalCar = carService.getById(id);

        if (optionalCar.isPresent()) {
            model.addAttribute("car", optionalCar.get());
            model.addAttribute("dto", new BooleanDTO());
            return "car_details";
        } else {
            return "id_error";
        }
    }

    @GetMapping("/proposal/details/dask/{id}")
    public String daskDetails(@PathVariable Long id, Model model) {
        Optional<Dask> optionalDask = daskService.getDaskById(id);

        if (optionalDask.isPresent()) {
            model.addAttribute("dask", optionalDask.get());
            model.addAttribute("dto", new BooleanDTO());
            return "dask_details";
        } else {
            return "id_error";
        }
    }

    @PostMapping("/proposals/accept/{id}")
    public String acceptProposal(@PathVariable Long id, @ModelAttribute("dto") BooleanDTO dto) {
        Optional<Proposal> optionalProposal = proposalService.getById(id);

        if (optionalProposal.isPresent()) {

            Proposal proposal = optionalProposal.get();

            if (!proposal.isStatus()) {

                proposal.setStatus(true);

                proposal.setProposalAcceptedDate(new Date(System.currentTimeMillis()));

                proposalService.save(proposal);
            }

            return dto.isFlag() ? "redirect:/proposals/accepted" : "redirect:/proposals";
        } else {
            return "id_error";
        }
    }

    @GetMapping("/proposal/delete/{id}")
    public String deleteProposal(@PathVariable Long id) {
        proposalService.deleteProposal(id);
        return "redirect:/proposals";
    }

    @GetMapping("/proposal/delete/accepted/{id}")
    public String deleteAcceptedProposal(@PathVariable Long id) {
        proposalService.deleteProposal(id);
        return "redirect:/proposals/accepted";
    }
}