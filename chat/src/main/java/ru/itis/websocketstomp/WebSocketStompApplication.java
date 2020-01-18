package ru.itis.websocketstomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ru.itis.websocketstomp")
@EnableEurekaClient
public class WebSocketStompApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebSocketStompApplication.class, args);
    }

}
