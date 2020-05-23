package com.hahak.serviceBaseUser.dto;

import lombok.Data;

/**
 * @ClassName TokenEntity
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 00:44
 * @Version 1.0
 **/
@Data
public class TokenEntity {

    private String access_token;
    private String token_type;
    private String refresh_token;
    private Long expires_in;
    private String  scope;
}
