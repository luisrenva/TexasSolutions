package com.example.texassolutions.controller;

import com.example.texassolutions.model.Application;
import com.example.texassolutions.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final ApplicationService applicationService;



    @GetMapping(API_ENDPOINT + "applications")
    public List<Application> getApplications() {
        return applicationService.getApplications();
    }

    @GetMapping(API_ENDPOINT + "applications/{id}")
    public ResponseEntity<Optional<Application>> getApplicationById(@PathVariable int id) {
         return ResponseEntity.ok(applicationService.getApplicationById(id));
    }
}
