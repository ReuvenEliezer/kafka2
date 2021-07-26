package com.kafka.producer.controllers;

import com.kafka.producer.services.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("messages")
public class MsgController {

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "sendMessage/{msg}")
    public Integer sendMessage(@PathVariable String msg) {
        //localhost:8080/messages/sendMessage/message
        //http://localhost:8080/swagger-ui/
       return kafkaProducer.sendMessage(msg);
    }

}