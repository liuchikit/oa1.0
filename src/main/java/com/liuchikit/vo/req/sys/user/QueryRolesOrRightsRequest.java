package com.liuchikit.vo.req.sys.user;

import com.liuchikit.vo.req.BaseRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/10 10:30
 */
@Data
public class QueryRolesOrRightsRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = 6647998668231551099L;

    private Long id;

    private String account;
}
