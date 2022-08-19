package com.sbm.insurance.services;

import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.repositories.DaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DaskService {

    @Autowired
    private DaskRepository daskRepository;

    public void save(Dask dask) {
        daskRepository.save(dask);
    }
}