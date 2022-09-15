package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskArea;
import com.sbm.insurance.repositories.DaskAreaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskAreaService {

    private final DaskAreaRepository daskAreaRepository;

    public DaskAreaService(DaskAreaRepository daskAreaRepository) {
        this.daskAreaRepository = daskAreaRepository;
    }

    public void save(DaskArea daskArea) {
        daskAreaRepository.save(daskArea);
    }

    public List<DaskArea> getAll() {
        return daskAreaRepository.findAll();
    }

    public float getAreaMultiplier(int area) {
        return daskAreaRepository.getPriceMultiplier(area);
    }
}