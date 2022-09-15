package com.sbm.insurance.services;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.ProposalRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public void updateStatusById(Long id) {
        proposalRepository.updateStatusById(id);
    }

    public void setAcceptedDate(Long id, String date) {
        proposalRepository.setAcceptedDateById(id, date);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteProposalById(id);
    }
}