package com.hahak.serviceBaseUser.controller;

import java.io.UnsupportedEncodingException;
import java.net.Authenticator;
import java.sql.Date;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.hahak.serviceBaseUser.dto.LoginParam;
import com.hahak.serviceBaseUser.dto.TokenEntity;
import com.hahak.serviceBaseUser.dto.User;
import com.hahak.serviceBaseUser.service.UserService;
import com.hahak.serviceBaseUser.utils.ResultUtil;

import cn.hutool.core.util.StrUtil;
import entity.BaseResponse;
import enums.BaseStatusCode;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName UserController
 * @Description
 * @Author haha
 * @Date 2020/5/13 下午 15:55
 * @Version 1.0
 **/

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${custom.oauth2.grant_type}")
    private String oauth2_grant_type;

    @Value("${custom.oauth2.client_id}")
    private String oauth2_client_id;

    @Value("${custom.oauth2.client_secret}")
    private String oauth2_client_secret;

    @Autowired
    private RestTemplate restTemplate;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication, HttpServletRequest request) throws UnsupportedEncodingException {
        String header = request.getHeader("Authorization");
        String jwtToken = StrUtil.subAfter(header,"Bearer ",false);
        log.info(header);
        log.info(jwtToken);
        log.info(authentication.getPrincipal().toString());
        return Jwts.parser()
//                .setSigningKey(mySecreteKey)
//                .setSigningKey("mySecretKey")
                .setSigningKey("haha".getBytes("UTF-8"))
                .parseClaimsJws(jwtToken).getBody();
    }

    @GetMapping("/test")
    public Object Test(){
        return "testHAha";
    }

    @PostMapping("/login")
    public BaseResponse handleLogin(@RequestBody LoginParam loginParam){
//        log.info("login========"+loginParam.getPassword()+"||||||"+loginParam.getUsername());
        String tokenUrl = "http://localhost:6001/oauth/token";
//        User user = new User(loginParam.getUsername(),loginParam.getPassword());
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("username", loginParam.getUsername());
        multiValueMap.add("password", loginParam.getPassword());
        multiValueMap.add("grant_type", oauth2_grant_type);
        multiValueMap.add("client_id", oauth2_client_id);
        multiValueMap.add("client_secret", oauth2_client_secret);
        TokenEntity tokenEntity;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<>(multiValueMap, headers);

        try {
            tokenEntity = restTemplate.postForObject(tokenUrl,entity,TokenEntity.class);
        }catch (Exception e){
            tokenEntity = null;
        }

        if(null == tokenEntity){
            return new BaseResponse(BaseStatusCode.ERROR.getCode(),BaseStatusCode.ERROR.getMsg(),null);
        }

//        return ResultUtil.resultSuccess(user);
        return new BaseResponse(BaseStatusCode.SUCCESS.getCode(),BaseStatusCode.SUCCESS.getMsg(),tokenEntity);
    }

    @PostMapping("/")
    @ResponseBody
    public BaseResponse handleAddUser(@RequestBody User userInfo){
        if(userService.selectUserByName(userInfo.getUsername())!=null){
            return ResultUtil.resultError(null,"用户名已存在");
        }
        userInfo.setPassword(new BCryptPasswordEncoder().encode(userInfo.getPassword()));
        userService.save(userInfo);
        return ResultUtil.resultSuccess(userInfo);
    }

//    public Map<String,Object> handleAddUser(@RequestBody Map<String,String>userInfo){
//        if(userService.selectUserByName(userInfo.get("username"))!=null){
//            Map<String,Object> result = new HashMap<>();
//            result.put("msg","用户名已存在");
//            return ResultUtil.resultError(result);
//        }
//        User user = new User();
////        user.setUsername();
//
//        Map<String,Object> result = new HashMap<>();
//        return ResultUtil.resultSuccess(result);
//    }


//    @GetMapping(value = "/info")
//    //  @PreAuthorize("hasAnyRole['ADMIN,STUDENT,TEACHER']")
//    public Map<String, Object> getUserInfo() {
//        Date date = new Date(1586188800000L);
//        log.info(date.toString());
//        Map<String, Object> result = new HashMap<>();
//        User user = SecurityUtil.getUserInfo();
//        try {
////            if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
////            } else if (user.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_STUDENT"))) {
////            }
//        } catch (Exception e) {
//            log.error(e.toString());
//            result.put("msg", "没有此用户");
////            return ResultUtil.resultError(result);
//        }
//        result.put("title", "获取用户信息");
////        return ResultUtil.resultSuccess(result);
//    }


}
