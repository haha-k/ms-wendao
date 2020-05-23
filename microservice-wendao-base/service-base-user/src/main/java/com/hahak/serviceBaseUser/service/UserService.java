package com.hahak.serviceBaseUser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hahak.serviceBaseUser.dto.User;
import com.hahak.serviceBaseUser.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserService
 * @Description
 * @Author haha
 * @Date 2020/5/13 下午 15:24
 * @Version 1.0
 **/

public interface UserService extends IService<User> {
    public User selectUserByName(String username);



}
