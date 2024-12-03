package com.example.texassolutions.controller;

import com.example.texassolutions.model.Application;
import com.example.texassolutions.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;


    @GetMapping(API_ENDPOINT + "applications")
    public List<Application> getApplications() {
        return applicationService.getApplications();
    }

    @GetMapping(API_ENDPOINT + "applications/{id}")
    public Application getApplicationById(@PathVariable int id) {
        Optional<Application> application;
        try {
            application = Optional.ofNullable(applicationService.getApplicationById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (application.isPresent()) {
            return (Application) application.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found");
        }
    }
}
