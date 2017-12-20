package com.liuchikit.vo.req.sys.role;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/20 19:00
 */
@Data
public class RoleRelatedUserPageRequest extends RolePageRequest implements Serializable{

    private static final long serialVersionUID = 8933447005442362158L;

    private Long roleId;
}
