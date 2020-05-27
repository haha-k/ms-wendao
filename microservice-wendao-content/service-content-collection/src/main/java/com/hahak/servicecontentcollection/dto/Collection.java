package com.hahak.servicecontentcollection.dto;

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
@TableName("collection")
@Data
public class Collection extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "collection_id",type= IdType.AUTO)
    private Integer collectionId;

    private String userId;

    private Integer isPrivate;

    private String title;

    private String description;


}
