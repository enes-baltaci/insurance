package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.CarModelAge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelAgeRepository extends JpaRepository<CarModelAge, Long> {

    @Query(
            value = "SELECT model_age_multiplier FROM car_model_age WHERE model_age <= ?1 ORDER BY model_age DESC LIMIT 1",
            nativeQuery = true
    )
    float getPriceMultiplier(int inputAge);
}