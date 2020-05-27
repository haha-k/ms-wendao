package com.hahak.serviceapimember.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hahak.serviceapimember.feign.fallback.MemberServiceClientFallbackImpl;
import com.hahak.servicecommonbase.entity.BaseResponse;

/**
 * @ClassName memberServiceClient
 * @Description
 * @Author haha
 * @Date 2020/5/22 下午 12:23
 * @Version 1.0
 **/

@FeignClient(value = "service-base-collection",fallback = MemberServiceClientFallbackImpl.class)
public interface MemberServiceClient {

    @GetMapping(value = "/collection")
    BaseResponse getCollection(@RequestParam("userId")Integer userId);

}

