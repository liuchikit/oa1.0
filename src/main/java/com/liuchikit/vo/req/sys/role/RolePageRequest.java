package com.liuchikit.vo.req.sys.role;

import com.liuchikit.vo.req.BasePageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 11:46
 */
@Data
public class RolePageRequest extends BasePageRequest implements Serializable {

    private String roleName;

    private String roleCode;
}
