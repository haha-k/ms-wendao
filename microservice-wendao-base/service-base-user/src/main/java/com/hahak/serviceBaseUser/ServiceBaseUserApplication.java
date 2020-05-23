package com.hahak.serviceBaseUser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.hahak.serviceBaseUser.mapper")
@EnableDiscoveryClient
public class ServiceBaseUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceBaseUserApplication.class, args);
    }

}
