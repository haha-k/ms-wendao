package com.hahak.servicebasefollow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceBaseFollowApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBaseFollowApplication.class, args);
    }

}
