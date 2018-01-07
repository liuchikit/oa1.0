package com.liuchikit.controller.sys;

import com.liuchikit.service.sys.RoleService;
import com.liuchikit.vo.req.sys.role.RolePageRequest;
import com.liuchikit.vo.req.sys.role.RoleRelateRightRequest;
import com.liuchikit.vo.req.sys.role.RoleRelatedUserPageRequest;
import com.liuchikit.vo.req.sys.role.RoleSaveOrUpdateRequest;
import com.liuchikit.vo.res.BasePageResponse;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RoleResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author liuchikit
 * @Description 角色管理controller
 * @date 2017/12/8 11:13
 */
@RestController
@RequestMapping("/sys/role")
public class RoleController {

    private static final String PATH = "/role";

    @Resource
    private RoleService roleService;

    /**
     * 跳转到角色管理列表
     * @return
     */
    @RequestMapping(value = "/toRoleList",method = RequestMethod.GET)
    public ModelAndView toRoleList(){
        return new ModelAndView(PATH + "/roleList");
    }

    /**
     * 跳转到关联用户页面
     * @return
     */
    @RequestMapping(value = "/toRelateUserPage",method = RequestMethod.GET)
    public ModelAndView toRelateUserPage(){
        return new ModelAndView(PATH + "/relateUserPage");
    }

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public BasePageResponse list(RolePageRequest request){
        return roleService.list(request);
    }

    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public BaseResponse<RoleResponse> getById(Long id){
        return roleService.getResById(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public BaseResponse save(RoleSaveOrUpdateRequest request){
        return roleService.save(request);
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    public BaseResponse update(RoleSaveOrUpdateRequest request){
        return roleService.update(request);
    }

    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public BaseResponse deleteById(Long id){
        return roleService.deleteById(id);
    }

    /**
     * 绑定权限
     * @param request
     * @return
     */
    @RequestMapping(value = "/relateRights",method = RequestMethod.POST)
    public BaseResponse relateRights(RoleRelateRightRequest request){
        return roleService.relateRights(request);
    }

    /**
     * 查找关联用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryRelatedUsers",method = RequestMethod.GET)
    public BasePageResponse queryRelatedUsers(RoleRelatedUserPageRequest request){
        return roleService.queryRelatedUsers(request);
    }

    /**
     * 查找未关联用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/queryUnrelatedUsers",method = RequestMethod.GET)
    public BasePageResponse queryUnrelatedUsers(RoleRelatedUserPageRequest request){
        return roleService.queryUnrelatedUsers(request);
    }
}
