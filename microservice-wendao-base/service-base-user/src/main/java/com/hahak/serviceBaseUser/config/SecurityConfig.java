package com.hahak.serviceBaseUser.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.WebSecurityEnablerConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hahak.serviceBaseUser.config.security.UserAuthenticationProvider;
import com.hahak.serviceBaseUser.service.UserService;
import com.hahak.serviceBaseUser.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;
import sun.security.util.Password;

/**
 * @ClassName SecurityConfig
 * @Description
 *
 * @Author haha
 * @Date 2020/5/13 下午 13:47
 * @Version 1.0
 **/

@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
//        PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Autowired
    public UserAuthenticationProvider userAuthenticationProvider;

    @Autowired
    private UserServiceImpl userService;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
                .anyRequest().permitAll()
//                .and().formLogin().permitAll()
//                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/")
                //其余所有请求
//                .antMatchers("/user").permitAll()
//                .anyRequest().authenticated()
                //禁用csrf
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//        auth.authenticationProvider(userAuthenticationProvider);
//        auth
//                .inMemoryAuthentication()
//                .withUser("haha").password(passwordEncoder().encode("123456")).roles("user");
    }
}
