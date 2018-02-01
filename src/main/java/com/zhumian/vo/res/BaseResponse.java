package com.zhumian.vo.res;

import com.zhumian.constant.ResponseCode;
import com.zhumian.exception.BusinessException;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseResponse<T> implements Serializable{

    private static final long serialVersionUID = 2627826946086648087L;

    private boolean success;

    private Integer code;

    private T data;

    private String msg;

    public BaseResponse(){
        success = true;
        code = ResponseCode.SUCCESS.getCode();
        msg = ResponseCode.SUCCESS.getMsg();
    }

    public BaseResponse(T data){
        this.success = true;
        this.code = ResponseCode.SUCCESS.getCode();
        this.data = data;
    }

    public BaseResponse(boolean success,String msg){
        this.success = success;
        code = ResponseCode.SUCCESS.getCode();
        this.msg = msg;
    }

    public BaseResponse(BusinessException e){
        this.success = false;
        this.code = e.getErrorCode();
        this.msg = e.getErrorMsg();
    }
}
