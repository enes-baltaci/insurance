package com.sbm.insurance.services;

import com.sbm.insurance.entities.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AccountServiceTest {

    @Autowired
    private AccountService accountService;

    @Test
    void deleteAccount() {
        accountService.deleteAccount(1L);
    }
}