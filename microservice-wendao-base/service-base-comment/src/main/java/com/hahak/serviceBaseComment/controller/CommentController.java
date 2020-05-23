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


import com.hahak.serviceBaseComment.dto.Comment;
import com.hahak.serviceBaseComment.service.CommentService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName commentController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public BaseResponse getComments(){
        List<Comment> comments = commentService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comments);
    }

    @GetMapping("/{commentId}")
    public BaseResponse getCommentDetail(@PathVariable Integer commentId){
        Comment comment = commentService.getById(commentId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comment);
    }

    @DeleteMapping("/{commentId}")
    public BaseResponse deleteCommentDetail(@PathVariable Integer commentId){
//        Comment comment = commentService.getById(commentId);
        Boolean isSuccess = commentService.removeById(commentId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postComment(@RequestBody Comment comment){
//        Comment comment = commentService.getById(commentId);
        commentService.save(comment);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
