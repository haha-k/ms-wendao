package com.hahak.servicebasecollect.model.dto;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hahak.servicecommonbase.entity.CommonEntity;

import lombok.Data;

/**
 * @ClassName Answer
 * @Description
 * @Author haha
 * @Date 2020/5/20 下午 22:23
 * @Version 1.0
 **/
@TableName("collect")
@Data
public class Collect extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "collect_id",type= IdType.AUTO)
    private Integer collectId;

    private Integer userId;

    private Integer resourceId;

    private Integer resourceType;

    private Integer collectionId;
}
