package com.sbm.insurance.services;

import com.sbm.insurance.entities.Account;
import com.sbm.insurance.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public void save(@Valid Account account) {
        accountRepository.save(account);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }

}