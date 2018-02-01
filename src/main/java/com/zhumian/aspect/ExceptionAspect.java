package com.zhumian.aspect;

import com.zhumian.exception.BusinessException;
import com.zhumian.vo.res.BaseResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class ExceptionAspect {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Object handlerGlobalException(RuntimeException e){
        return new BaseResponse<>(e);
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Object handlerBusinessException(BusinessException e){
        return new BaseResponse<>(e);
    }

}
