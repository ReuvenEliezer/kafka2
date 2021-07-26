package com.kafka.producer.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaProducerImpl implements KafkaProducer {

    private static final Logger logger = LogManager.getLogger(KafkaProducerImpl.class);

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public Integer sendMessage(String msg) {
        kafkaTemplate.send("topic1", msg + counter.incrementAndGet());
        logger.info("sendingMsg: {}", msg + counter.get());
        return counter.get();
    }

}