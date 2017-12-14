package com.liuchikit.vo.req.sys.right;

import com.liuchikit.vo.req.BaseRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/11 21:41
 */
@Data
public class RightSaveOrUpdateRequest extends BaseRequest implements Serializable{

    private static final long serialVersionUID = -5908128603959637854L;

    private Long id;

    private Long pid;

    private String rightName;

    private String rightCode;

    private Integer rightType;

    private Integer level;

    private Integer sort;

    private Integer status;

}
