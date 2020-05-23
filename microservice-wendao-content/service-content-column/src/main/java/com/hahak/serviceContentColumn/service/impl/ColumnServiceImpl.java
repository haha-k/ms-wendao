package com.hahak.serviceContentColumn.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hahak.serviceContentColumn.dto.Column;
import com.hahak.serviceContentColumn.mapper.ColumnMapper;
import com.hahak.serviceContentColumn.service.ColumnService;

/**
 * @ClassName answerSerivceImpl
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:21
 * @Version 1.0
 **/
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, Column> implements ColumnService {
}
