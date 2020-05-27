package com.hahak.servicebasecollect.service.impl;

import javax.xml.ws.Action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicebasecollect.model.dto.Collect;
import com.hahak.servicebasecollect.mapper.CollectMapper;
import com.hahak.servicebasecollect.service.CollectService;
import com.hahak.servicecommonbase.vo.CollectVo;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class CollectServiceImpl extends ServiceImpl<CollectMapper, Collect> implements CollectService {

    @Autowired
    private CollectMapper collectMapper;

    @Override
    public int postCollect(CollectVo collectVo) {
        Collect collect = new Collect();
        collect.setCollectionId(collectVo.getFavlistId());
        collect.setResourceId(collectVo.getResourceId());
        collect.setResourceType(collectVo.getResourceType());
        return collectMapper.insert(collect);
    }
}
