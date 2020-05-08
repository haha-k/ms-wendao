package com.hahak.microservice_wendao_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceWendaoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWendaoEurekaApplication.class, args);
    }

}
