package com.sbm.insurance.services;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account save(@Valid Account account) {
        return accountRepository.save(account);
    }

}