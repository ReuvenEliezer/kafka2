package com.kafka.producer.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KafkaProducerImpl implements KafkaProducer {

    private static final Logger logger = LogManager.getLogger(KafkaProducerImpl.class);

    private AtomicInteger counter = new AtomicInteger(0);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value(value = "${kafka.producer.topic}")
    private String topicName;

    @Override
    public Integer sendMessage(String msg) {

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topicName, msg + counter.incrementAndGet());

        future.addCallback(new ListenableFutureCallback<>() {

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Sent message=[{}] with offset=[{}]", msg + counter.get(), result.getRecordMetadata().offset());
            }

            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message=[{}] due to: {}", msg, ex.getMessage());
                throw new RuntimeException(ex);
            }
        });
        return counter.get();
    }

}