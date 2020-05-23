package com.hahak.servicecontentqa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hahak.servicecontentqa.dto.Answer;
import com.hahak.servicecontentqa.feign.CollectionServiceClient;
import com.hahak.servicecontentqa.service.AnswerService;
import com.hahak.servicecontentqa.service.QuestionService;

import entity.BaseResponse;
import enums.BaseStatusCode;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName answerController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/answer")
@Slf4j
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private CollectionServiceClient collectionServiceClient;

    @GetMapping("")
    public BaseResponse getAnswers(){
        List<Answer>answers = answerService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),answers);
    }

    @GetMapping("/{answerId}")
    public BaseResponse getAnswerDetail(@PathVariable Integer answerId){
        Answer answer = answerService.getById(answerId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),answer);
    }

    @DeleteMapping("/{answerId}")
    public BaseResponse deleteAnswerDetail(@PathVariable Integer answerId){
//        Answer answer = answerService.getById(answerId);
        Boolean isSuccess = answerService.removeById(answerId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postAnswer(@RequestBody Answer answer){
//        Answer answer = answerService.getById(answerId);
        answerService.save(answer);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

    @GetMapping("/{answerId}/relations/collected")
    public BaseResponse getCollect(@PathVariable Integer answerId){
        String a = collectionServiceClient.getCollection(answerId);
        log.warn(a);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
