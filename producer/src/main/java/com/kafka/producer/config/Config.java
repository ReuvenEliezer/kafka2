//package com.kafka.producer.config;
//
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.TopicBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//public class Config {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//
////    @Bean
////    public NewTopic topic() {
////        return TopicBuilder.name("topic1")
////                .partitions(1)
////                .replicas(1)
////                .build();
////    }
//
//
////    @Bean
////    public ApplicationRunner runner(KafkaTemplate<String, String> template) {
////        template.send("topic1", "test1");
////        template.send("topic1", "test2");
////        return args -> {
////            template.send("topic1", "test3");
////        };
////    }
//
////    @Component
////    public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
////        /**
////         * This event is executed as late as conceivably possible to indicate that
////         * the application is ready to service requests.
////         */
////        @Override
////        public void onApplicationEvent(final ApplicationReadyEvent event) {
////            kafkaTemplate.send("topic1", "test4");
////        }
////    }
//
//}
