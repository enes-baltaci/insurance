package com.sbm.insurance.services;

import com.sbm.insurance.entities.TravelType;
import com.sbm.insurance.repositories.TravelTypesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelTypesService {

    private final TravelTypesRepository travelTypesRepository;

    public TravelTypesService(TravelTypesRepository travelTypesRepository) {
        this.travelTypesRepository = travelTypesRepository;
    }

    public void save(TravelType travelType) {
        travelTypesRepository.save(travelType);
    }

    public List<TravelType> getAll() {
        return travelTypesRepository.findAll();
    }
}