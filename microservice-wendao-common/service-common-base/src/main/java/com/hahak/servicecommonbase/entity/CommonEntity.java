package com.hahak.servicecommonbase.entity;


import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;


/**
 * @ClassName CommonEntity
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 01:33
 * @Version 1.0
 **/
@Data
public class CommonEntity {

    @TableField(value = "crt_time",fill = FieldFill.INSERT)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime crtTime;

    @TableField(value = "upd_time",fill = FieldFill.UPDATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updTime;

}
