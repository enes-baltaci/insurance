package com.sbm.insurance.entities;

import com.sbm.insurance.services.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AccountTest {

    @Autowired
    private AccountService accountService;

    @Test
    public void createAccount() {
        Account account = Account.builder()
                .email("sbm@gmail.com")
                .name("Nazif")
                .surname("Ilbek")
                .age(5)
                .build();

        accountService.save(account);
    }
}