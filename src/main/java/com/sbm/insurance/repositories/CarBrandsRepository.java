package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.CarBrand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandsRepository extends JpaRepository<CarBrand, Long> {

}