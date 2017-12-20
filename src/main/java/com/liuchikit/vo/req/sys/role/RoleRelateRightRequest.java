package com.liuchikit.vo.req.sys.role;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/17 13:09
 */
@Data
public class RoleRelateRightRequest implements Serializable{

    private static final long serialVersionUID = 3583760653922578655L;
    private Long roleId;
    private Long[] rightIds;
}
