package com.hahak.servicebasefavourite.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.servicebasefavourite.dto.Favourite;
import com.hahak.servicebasefavourite.mapper.FavouriteMapper;
import com.hahak.servicebasefavourite.service.FavouriteService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class FavouriteServiceImpl extends ServiceImpl<FavouriteMapper, Favourite> implements FavouriteService {
}
