package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskDamageStatus;
import com.sbm.insurance.repositories.DaskDamageStatusRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskDamageStatusService {

    private final DaskDamageStatusRepository daskDamageStatusRepository;

    public DaskDamageStatusService(DaskDamageStatusRepository daskDamageStatusRepository) {
        this.daskDamageStatusRepository = daskDamageStatusRepository;
    }

    public void save(DaskDamageStatus daskDamageStatus) {
        daskDamageStatusRepository.save(daskDamageStatus);
    }

    public List<DaskDamageStatus> getAll() {
        return daskDamageStatusRepository.findAll();
    }
}