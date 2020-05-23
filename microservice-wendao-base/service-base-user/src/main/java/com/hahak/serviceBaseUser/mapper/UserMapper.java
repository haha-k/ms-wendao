package com.hahak.serviceBaseUser.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hahak.serviceBaseUser.dto.User;

/**
 * @ClassName UserMapper
 * @Description
 * @Author haha
 * @Date 2020/5/13 下午 21:32
 * @Version 1.0
 **/
@Component
public interface UserMapper extends BaseMapper<User> {
}
