package com.zhumian.vo.req;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/6 14:39
 */
@Data
public class RegisterRequest implements Serializable{

    private static final long serialVersionUID = 8972308967244818532L;

    private String account;

    private String name;

    private String password;

    private Date birth;

    private String email;

    private String phone;

}
