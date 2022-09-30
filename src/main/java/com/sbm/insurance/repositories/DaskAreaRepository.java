package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.DaskArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskAreaRepository extends JpaRepository<DaskArea, Long> {

    @Query(
            value = "SELECT area_price_multiplier FROM dask_area WHERE dask_area.area <= ?1 ORDER BY area DESC LIMIT 1",
            nativeQuery = true
    )
    float getPriceMultiplier(int inputArea);
}