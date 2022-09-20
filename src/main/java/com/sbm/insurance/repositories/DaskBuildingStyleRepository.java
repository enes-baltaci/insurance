package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.DaskBuildingStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskBuildingStyleRepository extends JpaRepository<DaskBuildingStyle, Long> {

}