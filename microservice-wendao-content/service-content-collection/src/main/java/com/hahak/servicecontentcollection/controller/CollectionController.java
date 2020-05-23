package com.hahak.servicecontentcollection.controller;

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


import com.hahak.servicecontentcollection.dto.Collection;
import com.hahak.servicecontentcollection.service.CollectionService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName collectionController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/collection")
public class CollectionController {

    @Autowired
    private CollectionService collectionService;

//    @GetMapping("")
//    private String getCollection(@RequestParam("answerId")Integer answerId){
//        return "haha";
//    }

    @GetMapping("")
    public BaseResponse getCollections(){
        List<Collection> collections = collectionService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),collections);
    }

    @GetMapping("/{collectionId}")
    public BaseResponse getCollectionDetail(@PathVariable Integer collectionId){
        Collection collection = collectionService.getById(collectionId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),collection);
    }

    @DeleteMapping("/{collectionId}")
    public BaseResponse deleteCollectionDetail(@PathVariable Integer collectionId){
//        Collection collection = collectionService.getById(collectionId);
        Boolean isSuccess = collectionService.removeById(collectionId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postCollection(@RequestBody Collection collection){
//        Collection collection = collectionService.getById(collectionId);
        collectionService.save(collection);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
