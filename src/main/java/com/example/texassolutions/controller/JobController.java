package com.example.texassolutions.controller;

import com.example.texassolutions.exception.NotFoundException;
import com.example.texassolutions.model.Job;
import com.example.texassolutions.service.JobService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
@Slf4j
@RequiredArgsConstructor
public class JobController {
    // I should have an interface for implementing the endpoints=
    private final JobService jobService;

    //Best practice took from Mckesson
    //post method
//    public ResponseEntity<dto> functionName(DTO request) {
//        return ResponseEntity.ok(Optional.of(request)
//                .map(whatever::toModel)
//                .map(service::validateFunction)
//                .map(mappingFace::toValidatyeresponse)
//                .orElseThrow();
//
//        );
//    }

    // other example of post
    //public ResponseEntity<DTO> authorizePayment(user, dto)  {
//      call the service  service.authPayment() the service will throw the exception
//    return Response.ok(response);
    //}
    //

    @GetMapping(API_ENDPOINT + "jobs")
    public ResponseEntity<List<Job>> getJobs() {
        log.debug("Retrieving all jobs");
        List<Job> response = jobService.getJobs();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // I should have never an optional here
    @GetMapping(API_ENDPOINT + "jobs/{id}")
    public ResponseEntity<Optional<Job>> getJobById(@PathVariable int id) {
        log.debug("Getting job by id {}", id);
        //TODO: Move throw error logic to service layer
        Optional<Job> jobResponse = jobService.getJobById(id);
        if (jobResponse.isPresent()) {
            return new ResponseEntity<>(jobResponse, HttpStatus.OK);
        } else {
            throw new NotFoundException(); // exception should not being throw in the controller, delegate to service
        }
    }

    //This create has been created with best practices(Mckesson)
    @PostMapping(API_ENDPOINT + "jobs/createJob")
    public ResponseEntity<Job> createJob(@RequestHeader("Idempotency-Key") String idempotencyKey, @Valid @RequestBody Job job) {
        log.debug("Creating Job");
        Job jobCreated = jobService.createJob(idempotencyKey, job);
        return ResponseEntity.status(HttpStatus.CREATED).body(jobCreated);
    }

//    @PutMapping(API_ENDPOINT + "jobs/updateJob/{id}")
//    public ResponseEntity<Job> updateJob(@PathVariable int id, @Valid @RequestBody Job job) {
//        log.info("Updating job by id {}", id);
//        Job jobUpdated = jobService.updateJob(id, job);
//        return ResponseEnti


    // Best practice I took from backorder project Mckesson
    // This will be for a Get method
    // @override
    //@AuthUserActive
    //public ResponseEntity<DTO> fetchBackOrders@PathVariable String id) {
    // final List<BackOrderDTO>  backOrder = service.fetchBackOrders(id);
//    return ResponseEntity.ok(backOrder.stream()
//                .map(mapper::toDTO)
//                .collect(Collectors.toList()));



}