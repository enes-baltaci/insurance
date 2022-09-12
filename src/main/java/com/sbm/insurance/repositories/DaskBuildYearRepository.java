package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.DaskBuildYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskBuildYearRepository extends JpaRepository<DaskBuildYear, Long> {

    @Query(
            value = "SELECT build_year_multiplier FROM dask_build_year WHERE dask_build_year.build_year <= ?1 ORDER BY build_year DESC LIMIT 1",
            nativeQuery = true
    )
    float getPriceMultiplier(int inputBuildYear);
}