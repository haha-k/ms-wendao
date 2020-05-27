package com.hahak.serviceBaseComment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hahak.serviceBaseComment.dto.Comment;
import com.hahak.serviceBaseComment.dto.Reply;
import com.hahak.serviceBaseComment.service.CommentService;
import com.hahak.serviceBaseComment.service.ReplyService;
import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.enums.BaseStatusCode;
import com.hahak.servicecommonbase.vo.CommentVo;

import cn.hutool.core.bean.BeanUtil;


/**
 * @ClassName commentController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ReplyService replyService;

//    @GetMapping("")
//    public BaseResponse getComments(){
//        List<Comment> comments = commentService.list();
//        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comments);
//    }

    @GetMapping("")
    public BaseResponse getComments(@RequestParam Integer resourceId,@RequestParam Integer resourceType){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("resourse_id",resourceId);
        commentQueryWrapper.eq("resourse_type",resourceType);
        List<Comment> comments = commentService.list(commentQueryWrapper);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comments);
    }

    @GetMapping("/{commentId}")
    public BaseResponse getCommentDetail(@PathVariable Integer commentId){
        Comment comment = commentService.getById(commentId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comment);
    }

    @GetMapping("/{commentId}/child_comments")
    public BaseResponse getChildComment(@PathVariable Integer commentId){
        Comment comment = commentService.getById(commentId);
        QueryWrapper<Reply> replyQueryWrapper = new QueryWrapper<>();
        replyQueryWrapper.eq("comment_id",commentId);
        replyService.list(replyQueryWrapper);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),comment);
    }


    @GetMapping("/root_comments")
    public BaseResponse getRootComment(@RequestParam("resourceId") Integer resourceId,@RequestParam("resourceType")Integer resourceType){
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("resource_id",resourceId);
        commentQueryWrapper.eq("resource_type",resourceType);
        List<Comment>commentList = commentService.list(commentQueryWrapper);
        for(Comment comment:commentList){
            QueryWrapper<Reply> replyQueryWrapper = new QueryWrapper<>();
            replyQueryWrapper.eq("comment_id",comment.getCommentId());
            replyQueryWrapper.last("limit 2");
            List<Reply>replyList = replyService.list(replyQueryWrapper);
            comment.setChildComments(replyList);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),commentList);
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

    @PostMapping
    public BaseResponse postComment(@RequestBody CommentVo commentVo){
        Comment comment = new Comment();
        BeanUtil.copyProperties(commentVo,comment);
        commentService.save(comment);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

    @GetMapping("/{commentId}/anchor_comments")
    public BaseResponse getAnchorComments(@PathVariable Integer commentId){
        QueryWrapper<Reply> replyQueryWrapper = new QueryWrapper<>();
        replyQueryWrapper.eq("comment_id",commentId);
        List<Reply> anchorComments = replyService.list(replyQueryWrapper);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),anchorComments);
    }

}
