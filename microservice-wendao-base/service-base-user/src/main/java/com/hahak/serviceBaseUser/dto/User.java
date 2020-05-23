package com.hahak.serviceBaseUser.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import entity.CommonEntity;
import lombok.Data;

/**
 * @ClassName User
 * @Description
 * @Author haha
 * @Date 2020/5/13 下午 16:28
 * @Version 1.0
 **/

@Data
@TableName("user")
public class User extends CommonEntity implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id",type= IdType.AUTO)
    private Integer userId;
    private String username;
    private String password;
    private Integer sex;
    private String description;
    private String nickname;
    private Integer credit;
    private String subDesc;
    private String avatar;
    private Integer isAdmin;
    private Integer status;
    private String email;

    public User(String username, String password) {
        this.username = username;
        this.password = new BCryptPasswordEncoder().encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
