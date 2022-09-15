package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskFloorNumber;
import com.sbm.insurance.repositories.DaskFloorNumberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskFloorNumberService {

    private final DaskFloorNumberRepository daskFloorNumberRepository;

    public DaskFloorNumberService(DaskFloorNumberRepository daskFloorNumberRepository) {
        this.daskFloorNumberRepository = daskFloorNumberRepository;
    }

    public void save(DaskFloorNumber daskFloorNumber) {
        daskFloorNumberRepository.save(daskFloorNumber);
    }

    public List<DaskFloorNumber> getAll() {
        return daskFloorNumberRepository.findAll();
    }

    public float getFloorMultiplier(int floor) {
        return daskFloorNumberRepository.getPriceMultiplier(floor);
    }
}