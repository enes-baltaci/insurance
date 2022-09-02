package com.sbm.insurance.services;

import com.sbm.insurance.entities.TravelType;
import com.sbm.insurance.repositories.TravelTypesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelTypesService {

    @Autowired
    private TravelTypesRepository travelTypesRepository;

    public void save(TravelType travelType) {
        travelTypesRepository.save(travelType);
    }

    public List<TravelType> getAll() {
        return travelTypesRepository.findAll();
    }
}