package com.example.texassolutions.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Entity
@Data
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;

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

    private LocalTime createdDate;
    private LocalTime updatedDate;
}
