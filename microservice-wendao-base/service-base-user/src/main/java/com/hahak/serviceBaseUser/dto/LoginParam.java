package com.hahak.serviceBaseUser.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * @ClassName LoginParam
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 00:21
 * @Version 1.0
 **/
@Data
public class LoginParam implements Serializable {

    private String username;
    private String password;

}
