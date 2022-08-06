package com.sbm.insurance.services;

import com.sbm.insurance.entities.Travel;
import com.sbm.insurance.repositories.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
