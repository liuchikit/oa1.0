package com.liuchikit.vo.req.sys.user;

import com.liuchikit.vo.req.BaseRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/14 11:13
 */
@Data
public class UserSaveOrUpdateRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 7582197273572606140L;

    private Long id;

    private String account;

    private String name;

    private String password;

    private Date birth;

    private String email;

    private String phone;

    private Long deptId;

    private Long posId;
}
