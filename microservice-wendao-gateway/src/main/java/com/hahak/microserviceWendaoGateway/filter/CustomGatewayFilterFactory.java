package com.hahak.microserviceWendaoGateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;

/**
 * @ClassName CustomGatewayFilterFactory
 * @Description
 * @Author haha
 * @Date 2020/5/17 下午 23:00
 * @Version 1.0
 **/
public class CustomGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {

    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            return chain.filter(exchange);
        };
    }
}

