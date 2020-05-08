package com.hahak.microserviceWendaoFeign.clients.impl;

import org.springframework.stereotype.Component;

import com.hahak.microserviceWendaoFeign.clients.SehedualServiceHi;

/**
 * @ClassName SehedualServiceHiHystric
 * @Description
 * @Author haha
 * @Date 2020/5/5 下午 19:08
 * @Version 1.0
 **/

@Component
public class SehedualServiceHiHystric implements SehedualServiceHi {
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry"+name;
    }
}
