package com.hahak.serviceapimember.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hahak.serviceapimember.feign.MemberServiceClient;
import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.enums.BaseStatusCode;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName memberController
 * @Description
 * @Author haha
 * @Date 2020/5/22 下午 12:29
 * @Version 1.0
 **/
@RestController
@Slf4j
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberServiceClient memberServiceClient;

    @GetMapping("/{memberId}/favlists")
    public BaseResponse getCollection(@PathVariable Integer memberId){
        return memberServiceClient.getCollection(memberId);
    }

    @GetMapping("/{memberId}/questions")
    public BaseResponse getQuestion(@PathVariable Integer memberId){
        return memberServiceClient.getCollection(memberId);
    }

}
