package com.liuchikit.constant;

/**
 * {类说明}
 *
 * @author liaozijie
 * @date 2017/11/15
 */
public enum ResponseCode {

    SUCCESS(200,"服务调用成功"),
    ERROR(500,"系统异常");

    private int code;
    private String msg;

    ResponseCode(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }


}
