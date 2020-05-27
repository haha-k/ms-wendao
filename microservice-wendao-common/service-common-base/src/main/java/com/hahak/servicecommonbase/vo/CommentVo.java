package com.hahak.servicecommonbase.vo;

import lombok.Data;

/**
 * @ClassName CommentVo
 * @Description
 * @Author haha
 * @Date 2020/5/26 下午 16:19
 * @Version 1.0
 **/
@Data
public class CommentVo {
    private Integer resourceId;

    private Integer resourceType;

    private String content;

}
