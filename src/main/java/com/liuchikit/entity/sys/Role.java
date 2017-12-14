package com.liuchikit.entity.sys;

import com.liuchikit.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 11:48
 */
@Table(name = "TB_ROLE")
@Data
public class Role extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -5539172945479475695L;

    private String roleName;

    private String roleCode;

    private String roleDesc;

    private Integer status;


}
