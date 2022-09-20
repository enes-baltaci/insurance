package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.TravelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TravelTypesRepository extends JpaRepository<TravelType, Long> {

}