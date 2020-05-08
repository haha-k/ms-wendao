package com.hahak.microserviceWendaoFeign.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hahak.microserviceWendaoFeign.clients.impl.SehedualServiceHiHystric;

/**
 * @InterfaceName SehedualServiceHi
 * @Description
 * @Author haha
 * @Date 2020/5/5 下午 17:07
 * @Version 1.0
 **/

@FeignClient(value = "microservice-wendao-feed",fallback = SehedualServiceHiHystric.class)
public interface SehedualServiceHi {

    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam(value = "name")String name);

}
