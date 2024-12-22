package com.kafka.consumer.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.web.client.RestClient;

@Configuration
public class GeneralConfig {

    @Bean
    public ObjectMapper objectMapper() {
        return Jackson2ObjectMapperBuilder.json()
                .modules(new Jdk8Module(), new JavaTimeModule())
                .featuresToDisable(
                        SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,
                        DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
                )
                .featuresToEnable(
                        MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,
                        DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY
                )
                .build();
    }

    @Bean
    public RestClient restClient() {
        //TODO set timeout, ect..
        return RestClient.builder().build();
    }

}
