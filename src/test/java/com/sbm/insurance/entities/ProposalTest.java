package com.sbm.insurance.entities;

import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.ProposalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ProposalTest {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private AccountService accountService;

    @Test
    void createProposal() {

        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());

        Account account = Account.builder()
                .email("london@paris.com")
                .name("London")
                .surname("Paris")
                .age(5)
                .build();

        accountService.save(account);

        Proposal proposal = Proposal.builder()
                .price(5)
                .account(account)
                .proposalDate(formatter.format(date))
                .build();

        proposalService.save(proposal);
    }
}