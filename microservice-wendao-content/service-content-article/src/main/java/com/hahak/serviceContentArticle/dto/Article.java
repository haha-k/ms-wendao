package com.hahak.serviceContentArticle.dto;

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
@TableName("article")
@Data
public class Article extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id",type= IdType.AUTO)
    private Integer articleId;

    private Integer columnId;

    private Integer userId;

    private String title;

    private String content;

    private String photos;

    private String cover;

}
