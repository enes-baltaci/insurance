package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.Proposal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
    @Modifying
    @Transactional
    @Query(
            value = "UPDATE proposal SET status = true WHERE id = ?1",
            nativeQuery = true
    )
    int updateStatusById(Long id);
}