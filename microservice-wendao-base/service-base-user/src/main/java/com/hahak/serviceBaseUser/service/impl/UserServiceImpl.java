package com.hahak.serviceBaseUser.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.serviceBaseUser.dto.User;
import com.hahak.serviceBaseUser.mapper.UserMapper;
import com.hahak.serviceBaseUser.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserServiceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/16 下午 15:09
 * @Version 1.0
 **/

@Slf4j
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserDetailsService, UserService {

//    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        User user = userMapper.selectOne(userQueryWrapper);
        if(user == null) {
            throw new UsernameNotFoundException("用户名或密码错误");
        }
        log.info(user.toString());
//        String password = passwordEncoder.encode("123456");
        return user;
    }


    @Override
    public User selectUserByName(String username){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username",username);
        User user = userMapper.selectOne(userQueryWrapper);
        return user;
    }
}
