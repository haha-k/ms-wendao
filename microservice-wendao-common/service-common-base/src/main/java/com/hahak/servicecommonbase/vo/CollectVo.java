package com.hahak.servicecommonbase.vo;

import org.springframework.web.bind.annotation.RequestParam;

import lombok.Data;

/**
 * @ClassName CollectVo
 * @Description
 * @Author haha
 * @Date 2020/5/26 上午 11:21
 * @Version 1.0
 **/
@Data
public class CollectVo {
    Integer resourceId;

    Integer resourceType;

    Integer favlistId;
}
