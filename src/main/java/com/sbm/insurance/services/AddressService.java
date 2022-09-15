package com.sbm.insurance.services;

import com.sbm.insurance.entities.Address;
import com.sbm.insurance.repositories.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void save(Address address) {
        addressRepository.save(address);
    }
}