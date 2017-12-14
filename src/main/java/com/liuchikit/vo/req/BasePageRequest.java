package com.liuchikit.vo.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 11:02
 */
@Data
public class BasePageRequest extends BaseRequest implements Serializable {

    private static final long serialVersionUID = -2609061719299047120L;

    private Integer start;

    private Integer length;

    private Integer draw;

    public Integer getStart() {
        return start < 0 ? start  : (start / length + 1);
    }

    public void setStart(Integer start) {
        this.start =start < 0 ? 1 : start;
    }

}
