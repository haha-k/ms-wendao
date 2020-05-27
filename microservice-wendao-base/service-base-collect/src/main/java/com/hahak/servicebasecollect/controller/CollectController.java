package com.hahak.servicebasecollect.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hahak.servicebasecollect.model.dto.Collect;
import com.hahak.servicebasecollect.service.CollectService;
import com.hahak.servicecommonbase.entity.BaseResponse;
import com.hahak.servicecommonbase.enums.BaseStatusCode;
import com.hahak.servicecommonbase.vo.CollectVo;
import com.sun.org.apache.xpath.internal.operations.Bool;

import lombok.extern.slf4j.Slf4j;


/**
 * @ClassName collectController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/collect")
@Slf4j
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

    @GetMapping("/collected")
    public Boolean getCollected(@RequestParam("resourceId") Integer resourceId,
                                @RequestParam("resourceType")Integer resourceType,
                                @RequestParam("favlistId")Integer favlistId){
        QueryWrapper<Collect> collectQueryWrapper = new QueryWrapper<>();
        collectQueryWrapper.eq("resource_id",resourceId);
        collectQueryWrapper.eq("resource_type",resourceType);
        collectQueryWrapper.eq("collection_id",favlistId);
        List<Collect>collectList = collectService.list(collectQueryWrapper);
        log.info(collectList.toString());
        return collectList.isEmpty() ? false : true;
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

    @PostMapping
    public BaseResponse postCollect(@RequestBody CollectVo collectVo){
        int isSuccess =  collectService.postCollect(collectVo);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @DeleteMapping
    public BaseResponse deleteCollect(@RequestBody CollectVo collectVo){
        QueryWrapper<Collect> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("collection_id",collectVo.getFavlistId());
        queryWrapper.eq("resource_type",collectVo.getResourceType());
        queryWrapper.eq("resource_id",collectVo.getResourceId());
        Boolean isSuccess = collectService.remove(queryWrapper);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }
}
