package com.kafka.consumer.services;

import com.kafka.consumer.utils.WsAddressConstants;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class KafkaConsumer {

    private static final Logger logger = LogManager.getLogger(KafkaConsumer.class);

    private final RestClient restClient;

    public KafkaConsumer(RestClient restClient) {
        this.restClient = restClient;
    }

    @KafkaListener(topics = "${kafka.consumer.topic}",
            groupId = "${kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory")
    public void listen(@Payload byte[] message,
                       @Header(KafkaHeaders.ACKNOWLEDGMENT) Acknowledgment acknowledgment,
                       @Header(KafkaHeaders.OFFSET) int offSet,
                       @Header(KafkaHeaders.RECEIVED_TOPIC) String topicName,
                       @Header(KafkaHeaders.RECEIVED_PARTITION) String partitionId) {
        logger.info("Received Message {} on topic: {}, partitionId: {} offSet={}", new String(message), topicName, partitionId, offSet);
        ResponseEntity<Void> bodilessEntity = restClient.post()
                .uri(WsAddressConstants.sendPayloadUrl)
                .body(message)
                .retrieve()
                .toBodilessEntity();// Convert the response to a "void" response, similar to Void.class in RestTemplate

        acknowledgment.acknowledge();
    }


}
