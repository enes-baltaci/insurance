package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskBuildYear;
import com.sbm.insurance.repositories.DaskBuildYearRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskBuildYearService {

    private final DaskBuildYearRepository daskBuildYearRepository;

    public DaskBuildYearService(DaskBuildYearRepository daskBuildYearRepository) {
        this.daskBuildYearRepository = daskBuildYearRepository;
    }

    public void save(DaskBuildYear daskBuildYear) {
        daskBuildYearRepository.save(daskBuildYear);
    }

    public List<DaskBuildYear> getAll() {
        return daskBuildYearRepository.findAll();
    }

    public float getBuildYearMultiplier(int inputBuildYear) {
        return daskBuildYearRepository.getPriceMultiplier(inputBuildYear);
    }
}