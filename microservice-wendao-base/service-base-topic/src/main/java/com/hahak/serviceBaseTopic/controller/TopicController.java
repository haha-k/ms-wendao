package com.hahak.serviceBaseTopic.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.serviceBaseTopic.dto.Topic;
import com.hahak.serviceBaseTopic.service.TopicService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName topicController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("")
    public BaseResponse getTopics(){
        List<Topic> topics = topicService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),topics);
    }

    @GetMapping("/{topicId}")
    public BaseResponse getTopicDetail(@PathVariable Integer topicId){
        Topic topic = topicService.getById(topicId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),topic);
    }

    @DeleteMapping("/{topicId}")
    public BaseResponse deleteTopicDetail(@PathVariable Integer topicId){
//        Topic topic = topicService.getById(topicId);
        Boolean isSuccess = topicService.removeById(topicId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postTopic(@RequestBody Topic topic){
//        Topic topic = topicService.getById(topicId);
        topicService.save(topic);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
