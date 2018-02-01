package com.zhumian.vo.req;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/2 23:50
 */
@Data
public class LoginRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = -7483540858169864643L;

    @NotNull(message = "账号不能为空")
    private String account;

    @NotNull(message = "密码不能为空")
    private String password;

}
