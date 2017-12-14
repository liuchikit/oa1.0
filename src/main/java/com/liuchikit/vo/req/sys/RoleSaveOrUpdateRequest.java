package com.liuchikit.vo.req.sys;

import com.liuchikit.vo.req.BaseRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 13:46
 */
@Data
public class RoleSaveOrUpdateRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 5819586800576853609L;

    private Long id;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private Integer status;
}
