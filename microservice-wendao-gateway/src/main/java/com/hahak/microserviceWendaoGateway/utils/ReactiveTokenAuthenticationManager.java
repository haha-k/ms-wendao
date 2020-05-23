package com.hahak.microserviceWendaoGateway.utils;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.token.TokenStore;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * @ClassName ReactiveTokenAuthenticationManager
 * @Description
 * @Author haha
 * @Date 2020/5/17 下午 20:15
 * @Version 1.0
 **/

@Slf4j
public class ReactiveTokenAuthenticationManager implements ReactiveAuthenticationManager {

    private TokenStore tokenStore;

    public ReactiveTokenAuthenticationManager(TokenStore tokenStore) {
        this.tokenStore = tokenStore;
    }

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        return null;
    }
}
