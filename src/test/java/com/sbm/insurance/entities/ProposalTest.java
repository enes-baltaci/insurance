package com.sbm.insurance.entities;

import com.sbm.insurance.services.AccountService;
import com.sbm.insurance.services.ProposalService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class ProposalTest {

    @Autowired
    private ProposalService proposalService;

    @Autowired
    private AccountService accountService;

    @Test
    void createProposal() {

        Date date = new Date(System.currentTimeMillis());

        Proposal proposal = Proposal.builder()
                .price(5)
                .proposalDate(date)
                .build();

        proposalService.save(proposal);
    }
}