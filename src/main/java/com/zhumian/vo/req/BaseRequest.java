package com.zhumian.vo.req;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/2 23:08
 */
@Data
@ToString
public class BaseRequest implements Serializable{

    private static final long serialVersionUID = 4153152371412039984L;

    private Long creatorId;

    private String creator;

    private Date createTime;

    private Long upadterId;

    private String updater;

    private Date updateTime;

}
