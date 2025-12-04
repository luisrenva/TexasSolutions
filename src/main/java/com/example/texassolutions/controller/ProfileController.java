package com.example.texassolutions.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
public class ProfileController {

    @Autowired
    private Environment env;

    @Value("${spring.profiles.active:}")
    private String activeProfiles;

    @GetMapping(API_ENDPOINT + "profile")
    public String getProfile() {
        return activeProfiles;
//        return Arrays.toString(env.getActiveProfiles());
    }
}
