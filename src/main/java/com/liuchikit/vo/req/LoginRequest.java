package com.liuchikit.vo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/2 23:50
 */
@Data
public class LoginRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = -7483540858169864643L;

    private String account;

    private String password;

}
