package com.hahak.servicecontentcollection.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.vo.CollectVo;
import com.hahak.servicecontentcollection.feign.fallback.CollectServiceClientFallbackImpl;

/**
 * @InterfaceName CollectServiceClient
 * @Description
 * @Author haha
 * @Date 2020/5/26 上午 10:19
 * @Version 1.0
 **/
@FeignClient(value = "service-base-collect",fallback = CollectServiceClientFallbackImpl.class)
public interface CollectServiceClient {

    @PostMapping("/collect")
    BaseResponse postCollect(@RequestBody CollectVo collectVo);

    @DeleteMapping("/collect")
    BaseResponse deleteCollect(@RequestBody CollectVo collectVo);
}
