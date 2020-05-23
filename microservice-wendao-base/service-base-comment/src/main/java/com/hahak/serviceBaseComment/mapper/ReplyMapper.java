package com.hahak.serviceBaseComment.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hahak.serviceBaseComment.dto.Reply;


/**
 * @ClassName answerMapper
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:23
 * @Version 1.0
 **/
@Mapper
public interface ReplyMapper extends BaseMapper<Reply> {
}
