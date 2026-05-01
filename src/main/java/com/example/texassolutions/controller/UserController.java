package com.example.texassolutions.controller;

import com.example.texassolutions.model.Users;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
@Slf4j
@RequiredArgsConstructor
class UserController {

    @GetMapping("api/v1/bigTest")
    public ResponseEntity<Integer> bigTest() {
        return new ResponseEntity<>(1, HttpStatus.OK);
    }

//    @GetMapping(API_ENDPOINT + "users/{id}")
//    public ResponseEntity<Users> getUsersById(@PathVariable int id) {
//        log.debug("Getting job by id {}", id);
//        return new ResponseEntity<>(new Users(), HttpStatus.OK);
//    }

    @GetMapping(API_ENDPOINT + "users/{id}")
    public ResponseEntity<Users> validateUsersById(@PathVariable int id) {
        log.debug("Validate user by id {}", id);
        return new ResponseEntity<>(new Users(), HttpStatus.OK);
    }
}