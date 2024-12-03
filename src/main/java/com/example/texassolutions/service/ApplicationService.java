package com.example.texassolutions.service;

import com.example.texassolutions.model.Application;
import com.example.texassolutions.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {

    @Autowired
    private ApplicationRepository applicationRepository;


    public List<Application> getApplications() {
        return applicationRepository.getApplications();
    }

    public Application getApplicationById(int id) {
        return applicationRepository.getApplicationById(id);
    }
}
