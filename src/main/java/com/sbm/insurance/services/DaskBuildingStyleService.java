package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskBuildingStyle;
import com.sbm.insurance.repositories.DaskBuildingStyleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskBuildingStyleService {

    @Autowired
    private DaskBuildingStyleRepository daskBuildingStyleRepository;

    public void save(DaskBuildingStyle daskBuildingStyle) {
        daskBuildingStyleRepository.save(daskBuildingStyle);
    }

    public List<DaskBuildingStyle> getAll() {
        return daskBuildingStyleRepository.findAll();
    }
}