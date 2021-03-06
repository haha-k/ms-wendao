package com.hahak.servicebasecollect.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.hahak.servicebasecollect.model.dto.Collect;
import com.hahak.servicecommonbase.vo.CollectVo;

/**
 * @InterfaceName answerService
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:49
 * @Version 1.0
 **/
public interface CollectService extends IService<Collect> {
    public int postCollect(CollectVo collectVo);
}
