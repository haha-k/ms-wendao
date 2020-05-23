package com.hahak.servicecommonbase.enums;

public enum BaseStatusCode {
    SUCCESS("请求成功",200),
    FAIL("客户端错误",400),
    NOT_FOUND("未找到",404),
    ERROR("服务器错误",500),
    UNAUTHORIZED("未授权",401);
    ;

    private String msg;
    private int code;

    BaseStatusCode(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
