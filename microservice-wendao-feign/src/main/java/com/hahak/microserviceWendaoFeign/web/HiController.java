package com.hahak.microserviceWendaoFeign.web;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hahak.microserviceWendaoFeign.clients.SehedualServiceHi;

/**
 * @ClassName HiController
 * @Description
 * @Author haha
 * @Date 2020/5/5 下午 17:07
 * @Version 1.0
 **/

@RestController
public class HiController {

    @Resource
    SehedualServiceHi sehedualServiceHi;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name){
        return sehedualServiceHi.sayHiFromClientOne(name);
    }

}
