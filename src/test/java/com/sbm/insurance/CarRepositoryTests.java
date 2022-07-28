package com.sbm.insurance;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.sbm.insurance.entity.Car;
import com.sbm.insurance.repository.CarRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class CarRepositoryTests {
    
    @Autowired
    private CarRepository repo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUser() {
        Car car = new Car();
        car.setEmail("sbm@gmail.com");
        car.setAge(5);
        car.setMemberYear(5);
        car.setModel("SUV");

        Car savedCar = repo.save(car);
        Car existCar = entityManager.find(Car.class, savedCar.getId());

        assertThat(existCar.getEmail()).isEqualTo(car.getEmail());
    }

    @Test
    public void testFindCarByEmail() {
        String email = "sbm@gmail.com";

        Car car = repo.findByEmail(email);

        assertThat(car).isNotNull();
    }
}