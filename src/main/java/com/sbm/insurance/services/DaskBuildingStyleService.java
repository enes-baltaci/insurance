package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskBuildingStyle;
import com.sbm.insurance.repositories.DaskBuildingStyleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskBuildingStyleService {

    private final DaskBuildingStyleRepository daskBuildingStyleRepository;

    public DaskBuildingStyleService(DaskBuildingStyleRepository daskBuildingStyleRepository) {
        this.daskBuildingStyleRepository = daskBuildingStyleRepository;
    }

    public void save(DaskBuildingStyle daskBuildingStyle) {
        daskBuildingStyleRepository.save(daskBuildingStyle);
    }

    public List<DaskBuildingStyle> getAll() {
        return daskBuildingStyleRepository.findAll();
    }
}