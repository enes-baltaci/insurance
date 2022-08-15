package com.sbm.insurance.entities;

import com.sbm.insurance.services.CarBrandsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class CarBrandsTest {

    @Autowired
    private CarBrandsService carBrandsService;

    @Test
    void initialBrands() {

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

        for (String str : brands) {
            CarBrands carBrands = CarBrands.builder().carBrand(str).build();
            carBrandsService.save(carBrands);
        }
    }

}