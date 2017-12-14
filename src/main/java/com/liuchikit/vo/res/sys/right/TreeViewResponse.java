package com.liuchikit.vo.res.sys.right;

import com.liuchikit.vo.res.BaseResponse;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/12 19:57
 */
@Data
public class TreeViewResponse implements Serializable{

    private static final long serialVersionUID = 4207445727672332174L;

    private Long id;
    private String text;
    private String url;
    private List<TreeViewResponse> nodes;
}
