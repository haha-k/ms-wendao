package com.hahak.servicebasefollow.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.servicebasefollow.dto.Follow;
import com.hahak.servicebasefollow.service.FollowService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName followController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private FollowService followService;

    @GetMapping("")
    public BaseResponse getFollows(){
        List<Follow> follows = followService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),follows);
    }

    @GetMapping("/{followId}")
    public BaseResponse getFollowDetail(@PathVariable Integer followId){
        Follow follow = followService.getById(followId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),follow);
    }

    @DeleteMapping("/{followId}")
    public BaseResponse deleteFollowDetail(@PathVariable Integer followId){
//        Follow follow = followService.getById(followId);
        Boolean isSuccess = followService.removeById(followId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postFollow(@RequestBody Follow follow){
//        Follow follow = followService.getById(followId);
        followService.save(follow);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
