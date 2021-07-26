package com.kafka.consumer.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

//    @Bean
//    public NewTopic topic() {
//        return TopicBuilder.name("topic1")
//                .partitions(1)
//                .replicas(1)
//                .build();
//    }

    @KafkaListener(topics = "topic1",
            groupId = "myId",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload String message,
                       @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                       @Header(KafkaHeaders.OFFSET) int offSet,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                       @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partitionId) {
        logger.info("Received Message {} on topic: {}, partitionId: {} offSet={}", message, topicName, partitionId, offSet);
        acknowledgment.acknowledge();
    }


}
