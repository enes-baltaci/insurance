package com.sbm.insurance.entities;

import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.CarBrandsService;
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

        for (Account account : accounts) {
            accountService.save(account);
        }

        for (CarBrands brands : carBrands) {
            carBrandsService.save(brands);
        }
    }

}