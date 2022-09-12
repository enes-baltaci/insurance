package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskArea;
import com.sbm.insurance.repositories.DaskAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskAreaService {

    @Autowired
    private DaskAreaRepository daskAreaRepository;

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