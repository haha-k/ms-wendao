package com.hahak.servicecontentqa.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.vo.CommentVo;
import com.hahak.servicecontentqa.feign.fallback.CommentServiceClientFallbackImpl;

/**
 * @ClassName CommentServiceClient
 * @Description
 * @Author haha
 * @Date 2020/5/24 下午 16:54
 * @Version 1.0
 **/

@FeignClient(value = "service-base-comment",fallback = CommentServiceClientFallbackImpl.class)
public interface CommentServiceClient {

    @GetMapping(value = "/comments/root_comments")
    BaseResponse getRootComments(@RequestParam("resourceId")Integer answerId, @RequestParam("resourceType")Integer type);

    @PostMapping("/comments")
    BaseResponse postComments(@RequestBody CommentVo commentVo);
}
