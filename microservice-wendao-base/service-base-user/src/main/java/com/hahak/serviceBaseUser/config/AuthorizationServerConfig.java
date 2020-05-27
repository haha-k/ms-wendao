package com.hahak.serviceBaseUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import com.hahak.serviceBaseUser.service.UserService;
import com.hahak.serviceBaseUser.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName AuthorizationServerConfig
 * @Description 认证服务配置
 * @Author haha
 * @Date 2020/5/13 下午 13:46
 * @Version 1.0
 **/
@Configuration
@EnableAuthorizationServer
@Slf4j
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private TokenStore jwtTokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    @Autowired
    private PasswordEncoder passwordEncoder;

    //配置AuthorizationServer 端点的非安全属性，
    // 也就是 token 存储方式、token 配置、用户授权模式等。
    // 默认不需做任何配置，除非使用 密码授权方式, 这时候必须配置 AuthenticationManager。

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(jwtTokenStore)
                .accessTokenConverter(jwtAccessTokenConverter)
                .userDetailsService(userService)
                .authenticationManager(authenticationManager);
//        super.configure(endpoints);
    }

    //配置独立client客户端的信息
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("admin")
//                .secret(passwordEncoder.encode("admin123456"))
//                .accessTokenValiditySeconds(3600)
//                .refreshTokenValiditySeconds(864000)
//                .redirectUris("")
//                .autoApprove(true)
//                .scopes("all")
//                .authorizedGrantTypes("authorization_code","password","refresh_token"); //添加授权模式
        log.info(passwordEncoder.encode("haha"));
        clients.inMemory()
                .withClient("haha")
                .secret(passwordEncoder.encode("haha"))
                .authorizedGrantTypes("password")
                .scopes("all");
//        super.configure(clients);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .passwordEncoder(passwordEncoder)
                .allowFormAuthenticationForClients();
                //配置authorization的安全属性,哪些能访问哪些不能访问
//        super.configure(security);
    }
}
