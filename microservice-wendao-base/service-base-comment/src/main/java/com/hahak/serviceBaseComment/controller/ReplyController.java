package com.hahak.serviceBaseComment.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hahak.serviceBaseComment.dto.Reply;
import com.hahak.serviceBaseComment.service.ReplyService;
import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.enums.BaseStatusCode;


/**
 * @ClassName replyController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @GetMapping("")
    public BaseResponse getReplys(){
        List<Reply> replys = replyService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),replys);
    }

    @GetMapping("/{replyId}")
    public BaseResponse getReplyDetail(@PathVariable Integer replyId){
        Reply reply = replyService.getById(replyId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),reply);
    }

    @DeleteMapping("/{replyId}")
    public BaseResponse deleteReplyDetail(@PathVariable Integer replyId){
//        Reply reply = replyService.getById(replyId);
        Boolean isSuccess = replyService.removeById(replyId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postReply(@RequestBody Reply reply){
//        Reply reply = replyService.getById(replyId);
        replyService.save(reply);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }




}
