package com.zhumian.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/6 14:41
 */
@Data
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = -6427139054076935340L;

    @Id
    private Long id;

    private Long creatorId;

    private String creator;

    private Date createTime;

    private Long updaterId;

    private String updater;

    private Date updateTime;
}
