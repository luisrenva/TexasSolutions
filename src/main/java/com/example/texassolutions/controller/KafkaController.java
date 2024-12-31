package com.example.texassolutions.controller;

//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.texassolutions.constants.TexasSolutionsConstants.API_ENDPOINT;

@RestController
public class KafkaController {


//    private final KafkaTemplate <String, String> kafkaTemplate;

//    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
//        this.kafkaTemplate = kafkaTemplate;
//    }

    @PostMapping(API_ENDPOINT + "send")
    public void sendMessage(@RequestBody String message) {
//        kafkaTemplate.send("my-topic", message);
    }


//    @KafkaListener(topics = "my-topic", groupId = "my-group")
//    public void listen(String message) {
//        System.out.println("Received message: " + message);
//    }



}
