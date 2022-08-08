package com.sbm.insurance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbm.insurance.entities.Car;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE car SET status = true WHERE id = ?1",
            nativeQuery = true
    )
    int updateStudentStatusById(Long id);
}