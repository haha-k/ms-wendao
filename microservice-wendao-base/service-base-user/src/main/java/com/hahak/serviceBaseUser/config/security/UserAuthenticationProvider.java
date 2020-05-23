package com.hahak.serviceBaseUser.config.security;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.hahak.serviceBaseUser.dto.User;
import com.hahak.serviceBaseUser.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserAuthenticationProvider
 * @Description
 * @Author haha
 * @Date 2020/5/16 下午 20:20
 * @Version 1.0
 **/
@Slf4j
@Component
public class UserAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User userInfo = userService.loadUserByUsername(userName);
        if(userInfo == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        if(!new BCryptPasswordEncoder().matches(password,userInfo.getPassword())){
            throw new BadCredentialsException("密码不正确");
        }
        if("PROHIBIT".equals(userInfo.getStatus())){
            throw new LockedException("该用户已被冻结");
        }
        return new UsernamePasswordAuthenticationToken(userInfo,password);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
