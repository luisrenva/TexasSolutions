package com.example.texassolutions.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class UserController {

    @GetMapping("api/v1/test")
    public String test() {
        return "working";
    }

    @GetMapping("api/v1/bigTest")
    public ResponseEntity<Integer> bigTest() {
        return new ResponseEntity<>(1, HttpStatus.OK);
        }
    }


//@GetMapping("/employees")
//List<Employee> all() {
//    return repository.findAll();
//}
