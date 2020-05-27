package com.hahak.serviceBaseComment.dto;

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
@TableName("reply")
@Data
public class Reply extends CommonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "reply_id",type= IdType.AUTO)
    private Integer replyId;

    private String content;

    private Integer fromUserId;

    private Integer toUserId;

    private Integer commentId;

}
