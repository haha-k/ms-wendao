package com.hahak.servicecontentqa.service.impl;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicecontentqa.dto.Answer;
import com.hahak.servicecontentqa.mapper.AnswerMapper;
import com.hahak.servicecontentqa.service.AnswerService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements AnswerService {
}
