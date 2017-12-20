package com.liuchikit.controller.sys;

import com.liuchikit.service.sys.RightService;
import com.liuchikit.vo.req.sys.right.RightQueryRequest;
import com.liuchikit.vo.req.sys.right.RightSaveOrUpdateRequest;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RoleResponse;
import com.liuchikit.vo.res.sys.right.RightResponse;
import com.liuchikit.vo.res.sys.right.TreeViewResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author liuchikit
 * @Description 角色管理controller
 * @date 2017/12/8 11:13
 */
@RestController
@RequestMapping("/sys/right")
public class RightController {

    private static final String PATH = "/right";


    @Resource
    private RightService rightService;

    /**
     * 跳转到权限管理列表
     * @return
     */
    @RequestMapping(value = "/toRightList",method = RequestMethod.GET)
    public ModelAndView toRightList(){
        return new ModelAndView(PATH + "/rightList");
    }

    /**
     * 获取实体
     * @param id
     * @return
     */
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public BaseResponse<RightResponse> getById(Long id){
        return rightService.getResById(id);
    }

    /**
     * 保存
     * @param request
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.POST)
    public BaseResponse save(RightSaveOrUpdateRequest request){
        return rightService.save(request);
    }


    /**
     * 更新
     * @param request
     * @return
     */
    @RequestMapping(value = "",method = RequestMethod.PUT)
    public BaseResponse update(RightSaveOrUpdateRequest request){
        return rightService.update(request);
    }

    @RequestMapping(value = "clearCache",method = RequestMethod.GET)
    public void clearCache(Integer type){
        rightService.clearCache(type);
    }

    /**
     * 根据type查询权限
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryRights",method = RequestMethod.GET)
    public BaseResponse queryRights(RightQueryRequest request){
        return rightService.queryRights(request);
    }

}
