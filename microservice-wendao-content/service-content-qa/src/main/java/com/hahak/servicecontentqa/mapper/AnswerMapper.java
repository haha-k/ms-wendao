package com.hahak.servicecontentqa.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hahak.servicecontentqa.dto.Answer;

/**
 * @ClassName answerMapper
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:23
 * @Version 1.0
 **/
@Mapper
public interface AnswerMapper extends BaseMapper<Answer> {
}
