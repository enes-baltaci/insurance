package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.DaskDamageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskDamageStatusRepository extends JpaRepository<DaskDamageStatus, Long> {

}