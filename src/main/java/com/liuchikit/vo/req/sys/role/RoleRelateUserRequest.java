package com.liuchikit.vo.req.sys.role;

import com.liuchikit.vo.req.BaseRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/20 19:00
 */
@Data
public class RoleRelateUserRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = -9094119606250018683L;

    private Long roleId;

    private Long[] userIds;
}
