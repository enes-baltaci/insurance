package com.sbm.insurance.services;

import com.sbm.insurance.entities.DaskDamageStatus;
import com.sbm.insurance.repositories.DaskDamageStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaskDamageStatusService {

    @Autowired
    private DaskDamageStatusRepository daskDamageStatusRepository;

    public void save(DaskDamageStatus daskDamageStatus) {
        daskDamageStatusRepository.save(daskDamageStatus);
    }

    public List<DaskDamageStatus> getAll() {
        return daskDamageStatusRepository.findAll();
    }
}