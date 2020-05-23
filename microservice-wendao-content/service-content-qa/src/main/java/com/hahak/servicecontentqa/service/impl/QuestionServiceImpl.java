package com.hahak.servicecontentqa.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicecontentqa.dto.Question;
import com.hahak.servicecontentqa.mapper.QuestionMapper;
import com.hahak.servicecontentqa.service.QuestionService;

/**
 * @ClassName questionServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:24
 * @Version 1.0
 **/
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {
}
