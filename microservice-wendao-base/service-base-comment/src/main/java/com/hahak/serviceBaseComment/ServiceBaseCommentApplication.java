package com.hahak.serviceBaseComment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBaseCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBaseCommentApplication.class, args);
    }

}
