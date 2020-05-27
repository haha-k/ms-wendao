package com.hahak.servicecontentqa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.enums.BaseStatusCode;
import com.hahak.servicecommonbase.vo.CommentVo;
import com.hahak.servicecontentqa.dto.Answer;
import com.hahak.servicecontentqa.feign.CollectServiceClient;
import com.hahak.servicecontentqa.feign.CommentServiceClient;
import com.hahak.servicecontentqa.service.AnswerService;
import com.hahak.servicecontentqa.service.QuestionService;

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
    private CollectServiceClient collectServiceClient;

    @Autowired
    private CommentServiceClient commentServiceClient;

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
    public BaseResponse getCollect(@PathVariable Integer answerId, @RequestBody Integer[] favlistIds){
        List<Object>list = new ArrayList<>();
        for(Integer favlistId : favlistIds){
            Map<String,Object> map = new HashMap<>();
            Boolean isCollected = collectServiceClient.getCollect(answerId,1,favlistId);
            map.put("collected",isCollected);
            map.put("favlist_id",favlistId);
            list.add(map);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),list);
    }

    @GetMapping("/{answerId}/root_comments")
    public BaseResponse getRootCommments(@PathVariable Integer answerId){
        return commentServiceClient.getRootComments(answerId,1);
//        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

    @PostMapping("/{answerId}/comments")
    public BaseResponse postComment(@RequestBody CommentVo commentVo){
        return commentServiceClient.postComments(commentVo);
    }


}
