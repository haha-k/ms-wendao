package com.hahak.servicebasecollect.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicebasecollect.dto.Collect;
import com.hahak.servicebasecollect.mapper.CollectMapper;
import com.hahak.servicebasecollect.service.CollectService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {
}
