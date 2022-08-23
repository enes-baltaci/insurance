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

        ArrayList<String> brands = new ArrayList<String>() {
            {
                add("Mercedes-Benz");
                add("BMW");
                add("Audi");
                add("Volkswagen");
                add("Nissan");
                add("Renault");
                add("Peugeot");
                add("Skoda");
                add("Opel");
                add("Mini Cooper");
                add("Hyundai");
                add("Kia");
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

        for (String str : brands) {
            CarBrands carBrands = CarBrands.builder().carBrand(str).build();
            carBrandsService.save(carBrands);
        }
    }

}