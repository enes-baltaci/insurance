package com.sbm.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbm.insurance.entities.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}