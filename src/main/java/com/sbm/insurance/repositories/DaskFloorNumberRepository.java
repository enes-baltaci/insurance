package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.DaskFloorNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskFloorNumberRepository extends JpaRepository<DaskFloorNumber, Long> {

    @Query(
            value = "SELECT floor_number_multiplier FROM dask_floor_number WHERE dask_floor_number.floor_number <= ?1 ORDER BY floor_number DESC LIMIT 1",
            nativeQuery = true
    )
    float getPriceMultiplier(int inputFloor);
}