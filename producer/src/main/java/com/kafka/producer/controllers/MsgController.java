package com.kafka.producer.controllers;

import com.kafka.producer.services.KafkaProducer;
import com.kafka.producer.services.KafkaProducerImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("messages")
public class MsgController {

    private static final Logger logger = LogManager.getLogger(MsgController.class);

    @Autowired
    private KafkaProducer kafkaProducer;

    @GetMapping(value = "sendMessage/{msg}")
    public Integer sendMessage(@PathVariable String msg) {
        //localhost:8080/messages/sendMessage/message
        //http://localhost:8080/swagger-ui/
        return kafkaProducer.sendMessage(msg);
    }

    @PostMapping(value = "payload")
    public void receivedPayload(@RequestBody byte[] msg) {
        logger.info("receivedPayload: {}", new String(msg));
    }

}