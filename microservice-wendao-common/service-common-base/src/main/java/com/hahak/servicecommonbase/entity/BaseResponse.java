package com.hahak.servicecommonbase.entity;

import com.hahak.servicecommonbase.enums.BaseStatusCode;

import lombok.Data;

/**
 * @ClassName Result
 * @Description
 * @Author haha
 * @Date 2020/5/18 上午 01:35
 * @Version 1.0
 **/
@Data
public class BaseResponse<T> {
    private Integer code;
    private String msg;
    private T data;

    public BaseResponse(){}

    public BaseResponse(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse(Integer code,T data){
        this.code = code;
        this.msg = "";
        this.data = data;
    }

    public static <T> BaseResponse success(T data){
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(BaseStatusCode.SUCCESS.getCode());
        baseResponse.setMsg(BaseStatusCode.SUCCESS.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }

    public static <T> BaseResponse failed(T data) {

        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setCode(BaseStatusCode.ERROR.getCode());
        baseResponse.setMsg(BaseStatusCode.ERROR.getMsg());
        baseResponse.setData(data);
        return baseResponse;
    }



}
