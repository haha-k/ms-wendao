package com.hahak.servicecontentqa.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hahak.servicecontentqa.dto.Question;

/**
 * @ClassName QuestionMapper
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:38
 * @Version 1.0
 **/
@Mapper
public interface QuestionMapper extends BaseMapper<Question> {
}
