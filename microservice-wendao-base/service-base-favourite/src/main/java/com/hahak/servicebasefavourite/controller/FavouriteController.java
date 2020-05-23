package com.hahak.servicebasefavourite.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hahak.servicebasefavourite.dto.Favourite;
import com.hahak.servicebasefavourite.service.FavouriteService;

import entity.BaseResponse;
import enums.BaseStatusCode;

/**
 * @ClassName favouriteController
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:47
 * @Version 1.0
 **/
@RestController
@RequestMapping("/favourite")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @GetMapping("")
    public BaseResponse getFavourites(){
        List<Favourite> favourites = favouriteService.list();
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),favourites);
    }

    @GetMapping("/{favouriteId}")
    public BaseResponse getFavouriteDetail(@PathVariable Integer favouriteId){
        Favourite favourite = favouriteService.getById(favouriteId);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),favourite);
    }

    @DeleteMapping("/{favouriteId}")
    public BaseResponse deleteFavouriteDetail(@PathVariable Integer favouriteId){
//        Favourite favourite = favouriteService.getById(favouriteId);
        Boolean isSuccess = favouriteService.removeById(favouriteId);
        if(!isSuccess){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),isSuccess);
    }

    @PostMapping("")
    public BaseResponse postFavourite(@RequestBody Favourite favourite){
//        Favourite favourite = favouriteService.getById(favouriteId);
        favouriteService.save(favourite);
//        if(isSuccess == false){
//            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),isSuccess);
//        }
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),true);
    }

}
