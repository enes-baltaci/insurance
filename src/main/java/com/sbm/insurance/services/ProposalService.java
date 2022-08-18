package com.sbm.insurance.services;

import com.sbm.insurance.entities.Proposal;
import com.sbm.insurance.repositories.ProposalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProposalService {

    @Autowired
    private ProposalRepository proposalRepository;

    public void save(Proposal proposal) {
        proposalRepository.save(proposal);
    }

    public List<Proposal> getAll() {
        return proposalRepository.findAll();
    }

    public Optional<Proposal> getById(Long id) {
        return proposalRepository.findById(id);
    }

    public int updateStatusById(Long id) {
        return proposalRepository.updateStatusById(id);
    }

    public int setAcceptedDate(Long id, String date) {
        return proposalRepository.setAcceptedDateById(id, date);
    }

    public void deleteProposal(Long id) {
        proposalRepository.deleteProposalById(id);
    }
}