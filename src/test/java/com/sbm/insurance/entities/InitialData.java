package com.sbm.insurance.entities;

import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarBrandsService;
import com.sbm.insurance.services.CarTypesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class InitialData {

    @Autowired
    private CarBrandsService carBrandsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CarTypesService carTypesService;

    @Test
    void initialData() {

        ArrayList<CarBrands> carBrands = new ArrayList<>() {
            {
                add(CarBrands.builder().carBrand("Mercedes-Benz").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("BMW").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("Audi").carBrandMultiplier(3f).build());
                add(CarBrands.builder().carBrand("Volkswagen").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Nissan").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Renault").carBrandMultiplier(2f).build());
                add(CarBrands.builder().carBrand("Peugeot").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Skoda").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Opel").carBrandMultiplier(1.5f).build());
                add(CarBrands.builder().carBrand("Mini Cooper").carBrandMultiplier(1.25f).build());
                add(CarBrands.builder().carBrand("Hyundai").carBrandMultiplier(1.25f).build());
                add(CarBrands.builder().carBrand("Kia").carBrandMultiplier(1.25f).build());
            }
        };

        ArrayList<Account> accounts = new ArrayList<>() {
            {
                add(Account.builder().identity(12345L).name("Enes").surname("Baltacı").email("enes@gmail.com").age(24).city("İstanbul").build());
                add(Account.builder().identity(12346L).name("Nazif").surname("İlbek").email("nazif@gmail.com").age(30).city("İstanbul").build());
                add(Account.builder().identity(12347L).name("İrem").surname("Er").email("irem@gmail.com").age(23).city("Muğla").build());
            }
        };

        ArrayList<CarTypes> carTypes = new ArrayList<>() {
            {
                add(CarTypes.builder().carType("Sedan").carTypeMultiplier(0.3f).build());
                add(CarTypes.builder().carType("SUV").carTypeMultiplier(0.15f).build());
                add(CarTypes.builder().carType("Hatchback").carTypeMultiplier(0.1f).build());
                add(CarTypes.builder().carType("MPV").carTypeMultiplier(0.12f).build());
                add(CarTypes.builder().carType("Crossover").carTypeMultiplier(0.27f).build());
                add(CarTypes.builder().carType("Coupe").carTypeMultiplier(0.17f).build());
                add(CarTypes.builder().carType("Convertible").carTypeMultiplier(0.25f).build());
            }
        };

        for (Account account : accounts) {
            accountService.save(account);
        }

        for (CarBrands brands : carBrands) {
            carBrandsService.save(brands);
        }

        for (CarTypes types : carTypes) {
            carTypesService.save(types);
        }
    }

}