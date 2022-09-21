package com.sbm.insurance.services;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProposalService {

    private final ProposalRepository proposalRepository;

    public ProposalService(ProposalRepository proposalRepository) {
        this.proposalRepository = proposalRepository;
    }

    public void save(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    public List<Proposal> getAll() {
        return proposalRepository.findAll();
    }

    public Optional<Proposal> getById(Long id) {
        return proposalRepository.findById(id);
    }

    public List<Proposal> proposalsByAccountId(Long id) {

        List<Proposal> proposals = getAll();

        List<Proposal> proposalsByAccount = new ArrayList<>();

        for (Proposal proposal : proposals) {
            if (proposal.getCar() != null && Objects.equals(proposal.getCar().getAccount().getId(), id)) {
                proposalsByAccount.add(proposal);
                continue;
            }

            if (proposal.getTravel() != null && Objects.equals(proposal.getTravel().getAccount().getId(), id)) {
                proposalsByAccount.add(proposal);
                continue;
            }

            if (proposal.getDask() != null && Objects.equals(proposal.getDask().getAccount().getId(), id)) {
                proposalsByAccount.add(proposal);
            }
        }

        return proposalsByAccount;
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteProposalById(id);
    }
}