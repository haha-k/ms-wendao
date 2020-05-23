package com.hahak.servicebasecounter.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicebasecounter.dto.Vote;
import com.hahak.servicebasecounter.mapper.VoteMapper;
import com.hahak.servicebasecounter.service.VoteService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class VoteServiceImpl extends ServiceImpl<VoteMapper, Vote> implements VoteService {
}
