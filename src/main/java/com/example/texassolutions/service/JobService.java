package com.example.texassolutions.service;

import com.example.texassolutions.exception.NotFoundException;
import com.example.texassolutions.model.IdempotencyKey;
import com.example.texassolutions.model.Job;
import com.example.texassolutions.repository.IdempotencyKeyRepository;
import com.example.texassolutions.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;

@Slf4j
@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private IdempotencyKeyRepository idempotencyKeyRepository;

    public List<Job> getJobs() {
        return jobRepository.findAll();
    }

    public Optional<Job> getJobById(int id) {
        return Optional.ofNullable(jobRepository.findByJobId(id)).orElseThrow(NotFoundException::new);
    }

    public Job createJob(String idempotencyKey, Job job) {
        // Logic to idempotent
        IdempotencyKey idempotencyResponse = idempotencyKeyRepository.findById(idempotencyKey).orElse(null);

        if (idempotencyResponse != null) {
            if (idempotencyResponse.getExpiryDate().isBefore(LocalDateTime.now())) {
                idempotencyKeyRepository.delete(idempotencyResponse);
            } else {
                Job jobRes = new Job();
                jobRes.setJobId(Integer.parseInt(idempotencyResponse.getResponse()));
                return jobRes;
            }
        }


        Job jobResponse = jobRepository.save(job);
        String response = "Job created with Id: " + jobResponse.getJobId();

        IdempotencyKey newKey = new IdempotencyKey();
        newKey.setIdempotentKey(idempotencyKey);
        newKey.setResponse(response);
        newKey.setExpiryDate(LocalDateTime.now().plusHours(24)); // 24-hour expiration
        idempotencyKeyRepository.save(newKey);

        return jobResponse;
    }

    public Job updateJob(int id, Job job) {
        Optional<Job> existingJob = jobRepository.findByJobId(id);
        if (existingJob.isPresent()) {
            return jobRepository.save(job);
        } else {
            throw new NotFoundException();
        }
    }

}