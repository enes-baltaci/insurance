package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarTypesRepository extends JpaRepository<CarModel, Long> {

}