package com.sbm.insurance.services;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.DaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class DaskService {

    @Autowired
    private DaskRepository daskRepository;

    @Autowired
    private DaskAreaService daskAreaService;

    @Autowired
    private DaskFloorNumberService daskFloorNumberService;

    @Autowired
    private DaskBuildYearService daskBuildYearService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private ProposalService proposalService;

    public void save(Dask dask) {
        daskRepository.save(dask);
    }

    public Optional<Dask> getDaskById(Long id) {
        return daskRepository.findById(id);
    }

    public void daskRegistration(Dask dask, Address address) {

        float price = 12;

        price *= address.getCity().getPriceMultiplier();

        price *= dask.getDaskBuildingStyle().getPriceMultiplier();

        price *= daskAreaService.getAreaMultiplier(dask.getArea());

        price *= dask.getDaskDamageStatus().getPriceMultiplier();

        price *= daskFloorNumberService.getFloorMultiplier(dask.getFloorNumber());

        price *= daskBuildYearService.getBuildYearMultiplier(Calendar.getInstance().get(Calendar.YEAR) - dask.getBuildYear());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Dask")
                .build();

        proposalService.save(proposal);

        dask.setProposal(proposal);

        addressService.save(address);

        save(dask);

        address.setDask(dask);

        dask.setAddress(address);

        addressService.save(address);

        save(dask);
    }
}