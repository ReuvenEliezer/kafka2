package com.kafka.producer.controllers;

import com.kafka.producer.services.KafkaProducer;
import com.kafka.producer.services.KafkaProducerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("messages")
public class MsgController {

    private static final Logger logger = LogManager.getLogger(MsgController.class);

    private final KafkaProducer kafkaProducer;

    public MsgController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping(value = "sendMessage/{msg}")
    public Integer sendMessage(@PathVariable String msg) {
        return kafkaProducer.sendMessage(msg);
    }

    @PostMapping(value = "payload")
    public void receivedPayload(@RequestBody byte[] msg) {
        logger.info("receivedPayload: {}", new String(msg));
    }

}