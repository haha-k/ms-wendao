package com.hahak.serviceBaseComment.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.serviceBaseComment.dto.Comment;
import com.hahak.serviceBaseComment.dto.Reply;
import com.hahak.serviceBaseComment.mapper.CommentMapper;
import com.hahak.serviceBaseComment.mapper.ReplyMapper;
import com.hahak.serviceBaseComment.service.CommentService;
import com.hahak.serviceBaseComment.service.ReplyService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class ReplyServiceImpl extends ServiceImpl<ReplyMapper, Reply> implements ReplyService {
}
