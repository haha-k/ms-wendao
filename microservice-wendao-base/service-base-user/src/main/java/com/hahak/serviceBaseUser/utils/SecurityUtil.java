package com.hahak.serviceBaseUser.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.hahak.serviceBaseUser.dto.User;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName SecurityUtil
 * @Description
 * @Author haha
 * @Date 2020/5/14 下午 17:34
 * @Version 1.0
 **/
@Slf4j
public class SecurityUtil {

    private SecurityUtil(){}

    public static User getUserInfo(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        Collection<? extends GrantedAuthority> userA =  SecurityContextHolder.getContext().getAuthentication().getAuthorities();
//        user.getUserId();
        return user;
    }

    public static Integer getUserId(){
        return getUserInfo().getUserId();
    }

    public static String getUserName(){
        return getUserInfo().getUsername();
    }

//    public static Collection<Role> getAuthorities(){
//        return  getUserInfo().getAuthorities();
//    }

//    public static T getInfo(){
////        return getAuthorities();
//        return T;
//    }
}
