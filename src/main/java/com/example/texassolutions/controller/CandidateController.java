package com.example.texassolutions.controller;

import com.example.texassolutions.model.Candidate;
import com.example.texassolutions.service.CandidateService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
@Slf4j
public class CandidateController {


    @Autowired
    private CandidateService candidateService;


    @GetMapping(API_ENDPOINT + "candidates/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable int id) {
        log.info("Getting candidate by id: {}", id);
        return new ResponseEntity<>(candidateService.getCandidateById(id), HttpStatus.OK);
    }

    @GetMapping(API_ENDPOINT + "candidates")
    public ResponseEntity<List<Candidate>> getCandidates() {
        return new ResponseEntity<>(candidateService.getCandidates(), HttpStatus.OK);
    }

    @PostMapping(API_ENDPOINT + "candidates/createCandidate")
    public HttpStatus createCandidate(@RequestBody Candidate candidate) {
        candidateService.createCandidate(candidate);
        log.debug("Create Candidate success");
        return HttpStatus.OK;
    }

}
