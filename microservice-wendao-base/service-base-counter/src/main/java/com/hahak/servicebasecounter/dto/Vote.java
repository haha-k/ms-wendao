package com.hahak.servicebasecounter.dto;

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
@TableName("vote")
@Data
public class Vote extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "vote_id",type= IdType.AUTO)
    private Integer voteId;

    private Integer userId;

    private Integer resourceId;

    private Integer voteResourceType;

    private Integer status;

    private Integer voteType;


}
