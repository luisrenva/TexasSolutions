package com.example.texassolutions.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalTime;

@Entity
public class JobPost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  jobPostId;

    private int companyId;
    private String status;
    private String createdBy;
    private String updatedBy;
    private LocalTime createdDate;
    private LocalTime updatedDate;

    public int getJobPostId() {
        return jobPostId;
    }

    public void setJobPostId(int jobPostId) {
        this.jobPostId = jobPostId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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




}
