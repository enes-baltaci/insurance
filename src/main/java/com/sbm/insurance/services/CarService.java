package com.sbm.insurance.services;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    private final CarRepository carRepository;

    private final CarModelAgeService carModelAgeService;

    private final ProposalService proposalService;

    public CarService(CarRepository carRepository,
                      CarModelAgeService carModelAgeService,
                      ProposalService proposalService) {
        this.carRepository = carRepository;
        this.carModelAgeService = carModelAgeService;
        this.proposalService = proposalService;
    }

    public void save(Car car) {
        carRepository.save(car);
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Optional<Car> getById(Long id) {
        return carRepository.findById(id);
    }

    public void carRegistration(Car car) {

        float price = 1025;

        Date date = new Date(System.currentTimeMillis());

        price *= car.getBrand().getCarBrandMultiplier();

        price *= carModelAgeService.getAgeMultiplier(Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear());

        price += (price * car.getModel().getCarTypeMultiplier());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(date)
                .type("Car")
                .build();

        proposalService.save(proposal);

        car.setProposal(proposal);

        save(car);
    }
}