package com.hahak.servicecommonbase.handler;

import java.time.LocalDateTime;
import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName MyMetaObjectHandler
 * @Description
 * @Author haha
 * @Date 2020/5/26 下午 19:24
 * @Version 1.0
 **/
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("-------------开始插入--------------");
        this.strictInsertFill(metaObject,"crtTime", LocalDateTime.class,LocalDateTime.now());
//
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("----------------------开始更新------------------");
        this.strictUpdateFill(metaObject,"updTime", LocalDateTime.class,LocalDateTime.now());
    }
}
