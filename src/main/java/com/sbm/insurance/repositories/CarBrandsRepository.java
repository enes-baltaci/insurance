package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.CarBrands;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarBrandsRepository extends JpaRepository<CarBrands, Long> {

}