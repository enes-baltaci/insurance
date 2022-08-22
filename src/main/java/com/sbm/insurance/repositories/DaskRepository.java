package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.Dask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface DaskRepository extends JpaRepository<Dask, Long> {
}