package com.hahak.serviceBaseComment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceBaseCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBaseCommentApplication.class, args);
    }

}
