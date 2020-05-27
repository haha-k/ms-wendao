package com.hahak.servicecontentqa.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hahak.servicecontentqa.feign.fallback.CollectServiceClientFallbackImpl;

/**
 * @InterfaceName QAServiceClient
 * @Description
 * @Author haha
 * @Date 2020/5/22 上午 00:09
 * @Version 1.0
 **/
@FeignClient(value = "service-base-collect",fallback = CollectServiceClientFallbackImpl.class)
public interface CollectServiceClient {

    @GetMapping(value = "/collect/collected")
    Boolean getCollect(@RequestParam("resourceId") Integer resourceId,
                         @RequestParam("resourceType")Integer resourceType,
                         @RequestParam("favlistId")Integer favlistId);

}
