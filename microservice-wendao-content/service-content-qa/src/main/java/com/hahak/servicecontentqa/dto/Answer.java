package com.hahak.servicecontentqa.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import entity.CommonEntity;
import lombok.Data;

/**
 * @ClassName Answer
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:23
 * @Version 1.0
 **/
@TableName("answer")
@Data
public class Answer extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "answer_id",type= IdType.AUTO)
    private Integer answerId;

    private Integer user_id;

    private Integer question_id;

    private String content;

    private String photos;
}
