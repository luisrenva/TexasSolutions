package com.example.texassolutions.service;

import com.example.texassolutions.model.Candidate;
import com.example.texassolutions.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;


    public Candidate getCandidateById(int candidateId) {
        return candidateRepository.findByCandidateId(candidateId);
    }

    public List<Candidate> getCandidates() {
        return candidateRepository.getCandidates();
    }

    public void createCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

}
