package com.sbm.insurance.services;

import com.sbm.insurance.entities.Car;
import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarModelAgeService carModelAgeService;

    @Autowired
    private ProposalService proposalService;

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

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());

        price *= car.getBrand().getCarBrandMultiplier();

        price *= carModelAgeService.getAgeMultiplier(Calendar.getInstance().get(Calendar.YEAR) - car.getModelYear());

        price += (price * car.getModel().getCarTypeMultiplier());

        Proposal proposal = Proposal.builder()
                .price(price)
                .proposalDate(formatter.format(date))
                .type("Car")
                .build();

        proposalService.save(proposal);

        car.setProposal(proposal);

        save(car);
    }
}