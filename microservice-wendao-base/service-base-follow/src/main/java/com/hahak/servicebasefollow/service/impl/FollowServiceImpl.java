package com.hahak.servicebasefollow.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicebasefollow.dto.Follow;
import com.hahak.servicebasefollow.mapper.FollowMapper;
import com.hahak.servicebasefollow.service.FollowService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class FollowServiceImpl extends ServiceImpl<FollowMapper, Follow> implements FollowService {
}
