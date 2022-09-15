package com.sbm.insurance.controllers;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.services.CarService;
import com.sbm.insurance.services.DaskService;
import com.sbm.insurance.services.ProposalService;
import com.sbm.insurance.services.TravelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
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

    private boolean detailsFlag = false;

    @GetMapping("/proposals")
    public String listProposals(Model model) {
        detailsFlag = false;
        model.addAttribute("proposals", proposalService.getAll());
        model.addAttribute("accepted", false);
        model.addAttribute("title", "Proposals");
        model.addAttribute("link", "proposals/accepted");
        model.addAttribute("linkName", "Accepted Proposals");
        return "proposals";
    }

    @GetMapping("/proposals/accepted")
    public String listAcceptedProposals(Model model) {
        detailsFlag = false;
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
            detailsFlag = true;
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
            detailsFlag = true;
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
            detailsFlag = true;
            return "dask_details";
        } else {
            return "id_error";
        }
    }

    @PostMapping("/proposals/accept/{id}")
    public String accept(@PathVariable Long id) {
        Optional<Proposal> optionalProposal = proposalService.getById(id);

        if (optionalProposal.isPresent()) {

            if (!optionalProposal.get().isStatus()) {

                proposalService.updateStatusById(optionalProposal.get().getId()); // Update status

                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");    // Set
                Date date = new Date(System.currentTimeMillis());                                        // accepted
                proposalService.setAcceptedDate(optionalProposal.get().getId(), formatter.format(date)); // date
            }

            return detailsFlag ? "redirect:/proposals/accepted" : "redirect:/proposals";
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