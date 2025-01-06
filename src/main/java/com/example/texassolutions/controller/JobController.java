package com.example.texassolutions.controller;

import com.example.texassolutions.exception.NotFoundException;
import com.example.texassolutions.model.Job;
import com.example.texassolutions.service.JobService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
@Slf4j
public class JobController {

    @Autowired
    private JobService jobService;

    @GetMapping(API_ENDPOINT + "jobs")
    public ResponseEntity<List<Job>> getJobs() {
        log.debug("Retrieving all jobs");
        List<Job> response = jobService.getJobs();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(API_ENDPOINT + "jobs/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable int id) {
        log.debug("Getting job by id {}", id);
        Optional<Job> jobResponse = jobService.getJobById(id);
        if ( jobResponse.isPresent()) {
            return new ResponseEntity<>(jobResponse, HttpStatus.OK);
        } else {
            throw new NotFoundException();
        }
    }

    @PostMapping(API_ENDPOINT + "jobs/createJob")
    public ResponseEntity<Job> createJob(@RequestHeader("Idempotency-Key") String idempotencyKey , @Valid @RequestBody Job job) {
        log.debug("Creating Job");
        Job jobCreated = jobService.createJob(idempotencyKey, job);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobCreated);
    }

    @PutMapping(API_ENDPOINT + "jobs/updateJob/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable int id, @Valid @RequestBody Job job) {
        log.info("Updating job by id {}", id);
        Job jobUpdated = jobService.updateJob(id, job);
        return ResponseEntity.ok(jobUpdated);
    }
}