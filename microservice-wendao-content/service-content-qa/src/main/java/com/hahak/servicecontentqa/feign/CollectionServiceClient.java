package com.hahak.servicecontentqa.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hahak.servicecontentqa.feign.fallback.CollectionServiceClientFallbackImpl;

/**
 * @InterfaceName QAServiceClient
 * @Description
 * @Author haha
 * @Date 2020/5/22 上午 00:09
 * @Version 1.0
 **/
@FeignClient(value = "service-base-collection",fallback = CollectionServiceClientFallbackImpl.class)
public interface CollectionServiceClient {

    @GetMapping(value = "/collection")
    String getCollection(@RequestParam("answerId")Integer answerId);

}
