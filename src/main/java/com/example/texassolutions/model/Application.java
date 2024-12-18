package com.example.texassolutions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int applicationId;

    @ManyToOne
    @JoinColumn(name = "job_id")
    @JsonProperty("jobs")
    private Job jobId;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    @JsonProperty("candidates")
    private Candidate candidateId;
    private String createdBy;
    private String updatedBy;

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public Job getJobId() {
        return jobId;
    }

    public void setJobId(Job jobId) {
        this.jobId = jobId;
    }

    public Candidate getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Candidate candidateId) {
        this.candidateId = candidateId;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    private LocalTime createdDate;
    private LocalTime updatedDate;

}
