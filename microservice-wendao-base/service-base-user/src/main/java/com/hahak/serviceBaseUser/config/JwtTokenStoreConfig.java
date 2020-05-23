package com.hahak.serviceBaseUser.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @ClassName JwtTokenStoreConfig
 * @Description jwt存储配置
 * @Author haha
 * @Date 2020/5/13 下午 15:24
 * @Version 1.0
 **/
@Configuration
public class JwtTokenStoreConfig {

    @Bean
    public TokenStore jwtTokenStore(){
        return new JwtTokenStore(jwtAccessTokenConverter()); }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter accessTokenConverter = new JwtAccessTokenConverter();
        accessTokenConverter.setSigningKey("haha");
        return accessTokenConverter;
//        final JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        // 导入证书
//        KeyStoreKeyFactory keyStoreKeyFactory =
//                new KeyStoreKeyFactory(new ClassPathResource("jwt.jks"), "mySecretKey".toCharArray());
//        converter.setKeyPair(keyStoreKeyFactory.getKeyPair("jwt"));
//        return converter;
    }
}
