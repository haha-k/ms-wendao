package com.hahak.servicecontentcollection.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicecontentcollection.dto.Collection;
import com.hahak.servicecontentcollection.mapper.CollectionMapper;
import com.hahak.servicecontentcollection.service.CollectionService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements CollectionService {
}
