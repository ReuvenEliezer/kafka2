package com.kafka.producer.services;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Component
public class CustomSpringEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            removeOldsLogsFile();
            startServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void startServer() throws IOException, InterruptedException {
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:/kafka/bin/windows/zookeeper-server-start.bat C:/kafka/config/zookeeper.properties\"");
//        Thread.sleep(10000);
        Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"C:/kafka/bin/windows/kafka-server-start.bat C:/kafka/config/server.properties\"");
    }

    private void removeOldsLogsFile() throws IOException {
        /**
         * https://stackoverflow.com/questions/45599625/kafka-unable-to-start-kafka-process-can-not-access-file-00000000000000000000
         * https://stackoverflow.com/questions/55298538/close-kafka-via-terminal
         */
        String projectPath = Paths.get("").toAbsolutePath().toString();
        String kafkaLog = projectPath + File.separator + "kafkadataKafka";
        FileUtils.deleteDirectory(new File(kafkaLog));
        String zookeeperLog = projectPath + File.separator + "kafkadataZookeeper";
        FileUtils.deleteDirectory(new File(zookeeperLog));
    }
}
