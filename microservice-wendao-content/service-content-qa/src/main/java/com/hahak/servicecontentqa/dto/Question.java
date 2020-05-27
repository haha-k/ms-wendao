package com.hahak.servicecontentqa.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hahak.servicecommonbase.entity.CommonEntity;

import lombok.Data;

/**
 * @ClassName question
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 17:49
 * @Version 1.0
 **/
@TableName("question")
@Data
public class Question extends CommonEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "question_id",type= IdType.AUTO)
    private Integer questionId;

    private String title;

    private String description;

    private String topics;

    private String photos;

    private Integer user_id;

    private Integer pageviews;


}
