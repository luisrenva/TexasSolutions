package com.example.texassolutions.controller;

//Endpoints
//GET /todos: Retrieve all to-do items.
//
//        GET /todos/{id}: Retrieve a specific to-do item by ID.
//
//        POST /todos: Create a new to-do item.
//
//        PUT /todos/{id}: Update an existing to-do item by ID.
//
//        DELETE /todos/{id}: Delete a to-do item by ID

//Parking Lot System Design with multiple parking lot sizes

import com.example.texassolutions.model.ParkingSpot;
import com.example.texassolutions.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ParkingController {

    @Autowired
    private ParkingService parkingService;



    @GetMapping("api/v1/parking/availableSlots")
    public ResponseEntity<List<ParkingSpot>> getAvailableSlots() {
        return new ResponseEntity<>(parkingService.availableSpots(), HttpStatus.OK);
    }


//    @PostMapping("api/v1/parking/addParking")




}
