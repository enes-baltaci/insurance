package com.sbm.insurance.repositories;

import com.sbm.insurance.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

}