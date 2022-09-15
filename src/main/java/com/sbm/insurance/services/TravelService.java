package com.sbm.insurance.services;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    @Autowired
    private ProposalService proposalService;

    public void save(Travel travel) {
        travelRepository.save(travel);
    }

    public List<Travel> getAll() {
        return travelRepository.findAll();
    }

    public Optional<Travel> getById(Long id) {
        return travelRepository.findById(id);
    }

    public void travelRegistration(Travel travel) {

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

        save(travel);
    }
}
