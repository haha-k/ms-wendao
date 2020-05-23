package com.hahak.servicebasecollect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.servicebasecollect.dto.Collect;
import com.hahak.servicebasecollect.service.CollectService;

import entity.BaseResponse;
import enums.BaseStatusCode;


/**
 * @ClassName collectController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    @GetMapping("")
    public BaseResponse getCollects(){
        List<Collect> collects = collectService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),collects);
    }

    @GetMapping("/{collectId}")
    public BaseResponse getCollectDetail(@PathVariable Integer collectId){
        Collect collect = collectService.getById(collectId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),collect);
    }

    @DeleteMapping("/{collectId}")
    public BaseResponse deleteCollectDetail(@PathVariable Integer collectId){
//        Collect collect = collectService.getById(collectId);
        Boolean isSuccess = collectService.removeById(collectId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postCollect(@RequestBody Collect collect){
//        Collect collect = collectService.getById(collectId);
        collectService.save(collect);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }
}
