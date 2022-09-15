package com.sbm.insurance.services;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.entities.Dask;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.DaskRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

@Service
public class DaskService {

    private final DaskRepository daskRepository;

    private final DaskAreaService daskAreaService;

    private final DaskFloorNumberService daskFloorNumberService;

    private final DaskBuildYearService daskBuildYearService;

    private final AddressService addressService;

    private final ProposalService proposalService;

    public DaskService(DaskRepository daskRepository,
                       DaskAreaService daskAreaService,
                       DaskFloorNumberService daskFloorNumberService,
                       DaskBuildYearService daskBuildYearService,
                       AddressService addressService,
                       ProposalService proposalService) {
        this.daskRepository = daskRepository;
        this.daskAreaService = daskAreaService;
        this.daskFloorNumberService = daskFloorNumberService;
        this.daskBuildYearService = daskBuildYearService;
        this.addressService = addressService;
        this.proposalService = proposalService;
    }

    public void save(Dask dask) {
        daskRepository.save(dask);
    }

    public Optional<Dask> getDaskById(Long id) {
        return daskRepository.findById(id);
    }

    public void daskRegistration(Dask dask, Address address) {

        float price = 4;

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