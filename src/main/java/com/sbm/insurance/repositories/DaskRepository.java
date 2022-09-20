package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.Dask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaskRepository extends JpaRepository<Dask, Long> {

}