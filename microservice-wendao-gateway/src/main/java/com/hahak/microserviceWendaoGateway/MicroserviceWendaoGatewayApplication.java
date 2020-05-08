package com.hahak.microserviceWendaoGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
@EnableEurekaClient
@Configuration
public class MicroserviceWendaoGatewayApplication {

    String httpUrl = "http://localhost:8763";

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceWendaoGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/hi")
                        .filters(f -> f.addRequestHeader("Hello","World"))
                        .uri(httpUrl))
                .route(p -> p
                        .host("*.hystrix.com")
                        .filters(f -> f
                                .hystrix(config -> config
                                .setName("haha")
                                .setFallbackUri("forward:/fallback")))
                        .uri(httpUrl)
                )
                .build();
    }

    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("fallback");
    }


}
