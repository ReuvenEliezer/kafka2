package com.kafka.producer.services;

public interface KafkaProducer {
    Integer sendMessage(String msg);
}
