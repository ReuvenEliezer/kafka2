package com.kafka.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ProducerApp {

    public static void main(String[] args) throws Exception {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:/kafka/bin/windows/zookeeper-server-start.bat C:/kafka/config/zookeeper.properties\"");
        Thread.sleep(10000);
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:/kafka/bin/windows/kafka-server-start.bat C:/kafka/config/server.properties\"");
        SpringApplication.run(ProducerApp.class, args);
    }

}
