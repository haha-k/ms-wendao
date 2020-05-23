package com.hahak.serviceBaseTopic.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.serviceBaseTopic.dto.Topic;
import com.hahak.serviceBaseTopic.mapper.TopicMapper;
import com.hahak.serviceBaseTopic.service.TopicService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements TopicService {
}
