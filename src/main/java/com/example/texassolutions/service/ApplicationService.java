package com.example.texassolutions.service;

import com.example.texassolutions.model.Application;
import com.example.texassolutions.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class ApplicationService {

    @Autowired
    private final ApplicationRepository applicationRepository;


    public List<Application> getApplications() {
        return applicationRepository.getApplications();
    }

    public Optional<Application> getApplicationById(int id) {
        return Optional.ofNullable(applicationRepository.getApplicationById(id));
    }
}
