package com.example.texassolutions.repository;

import com.example.texassolutions.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {

    Candidate findByCandidateId(int id);

    @Query(value = "SELECT * FROM CANDIDATE WHERE CANDIDATE.CANDIDATE_ID = :id", nativeQuery = true)
    Candidate testingQL(int id);
    //findById

    @Query(value = "SELECT *FROM CANDIDATE", nativeQuery = true)
    List<Candidate> getCandidates();

//    void createCandidate(Candidate candidate);

}
