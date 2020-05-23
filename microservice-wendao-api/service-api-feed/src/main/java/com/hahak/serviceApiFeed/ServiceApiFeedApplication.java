package com.hahak.serviceApiFeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApiFeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApiFeedApplication.class, args);
    }

}
