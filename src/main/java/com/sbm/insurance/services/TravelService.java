package com.sbm.insurance.services;

import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TravelService {

    @Autowired
    private TravelRepository travelRepository;

    public void save(Travel travel) {
        travelRepository.save(travel);
    }

    public List<Travel> getAll() {
        return travelRepository.findAll();
    }

    public Optional<Travel> getById(Long id) {
        return travelRepository.findById(id);
    }

    public int updateTravelStatusById(Long id) {
        return travelRepository.updateTravelStatusById(id);
    }
}
