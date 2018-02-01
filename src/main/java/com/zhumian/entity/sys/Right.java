package com.zhumian.entity.sys;

import com.zhumian.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/10 10:47
 */
@Data
@Table(name = "TB_RIGHT")
public class Right extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -7420878373755300295L;

    private Long pid;

    private String rightName;

    private String rightCode;

    private Integer rightType;

    private Integer level;

    private Integer sort;

    private Integer status;
}
