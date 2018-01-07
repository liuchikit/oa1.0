package com.liuchikit.service.sys.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.liuchikit.constant.ResponseMsg;
import com.liuchikit.entity.sys.Role;
import com.liuchikit.entity.sys.User;
import com.liuchikit.mapper.sys.RoleMapper;
import com.liuchikit.service.BaseServiceImpl;
import com.liuchikit.service.sys.RoleService;
import com.liuchikit.util.ConvertUtil;
import com.liuchikit.vo.req.sys.role.*;
import com.liuchikit.vo.res.BasePageResponse;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RolePageResponse;
import com.liuchikit.vo.res.sys.RoleResponse;
import com.liuchikit.vo.res.sys.user.UserResponse;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 12:34
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role,Long> implements RoleService {

    @Resource
    private RoleMapper mapper;

    @Resource(name = "roleMapper")
    @Override
    public void setMapper(Mapper<Role> mapper) {
        super.mapper = mapper;
    }

    @Override
    public BaseResponse save(RoleSaveOrUpdateRequest request) {
        Role role = new Role();
        ConvertUtil.objectToObject(request,role,true,true,true);
        BaseResponse validate = validate(role);
        if(validate.isSuccess()){
            return save(role);
        }
        return validate;
    }

    @Override
    public BaseResponse update(RoleSaveOrUpdateRequest request) {
        Role role = new Role();
        ConvertUtil.objectToObject(request,role,true,true,true);
        BaseResponse validate = validate(role);
        if(validate.isSuccess()){
            return update(role);
        }
        return validate;

    }

    /**
     * 校验角色名称编码唯一
     * @param role
     * @return
     */
    private BaseResponse validate(Role role){
        String msg = "";
        boolean flag = true;

        Role name = new Role();
        name.setRoleName(role.getRoleName());
        List<Role> names = findByParams(name,false);
        if(!names.isEmpty()){
            flag = false;
            msg = "角色名称已被占用";
        }

        Role code = new Role();
        name.setRoleCode(role.getRoleCode());
        List<Role> codes = findByParams(code,false);
        if(!codes.isEmpty()){
            flag = false;
            msg = "角色编码已被占用";
        }

       return new BaseResponse(flag,msg);

    }

    @Override
    public BasePageResponse list(RolePageRequest request) {
        Page<Object> page = PageHelper.startPage(request.getStart(),
                request.getLength());
        Role searcher = new Role();
        ConvertUtil.objectToObject(request,searcher,true);
        List<Role> roles = findByParams(searcher);
        List<RolePageResponse> responses = new ArrayList<>(roles.size());
        ConvertUtil.listObjectToListObject(roles,responses,RolePageResponse.class);
        return new BasePageResponse(request.getDraw(),page.getTotal(),responses);
    }

    @Override
    public BaseResponse<RoleResponse> getResById(Long id) {
        Role role = getById(id);
        if(role != null){
            RoleResponse response = new RoleResponse();
            ConvertUtil.objectToObject(role,response);
            return new BaseResponse<>(response);
        }
        return new BaseResponse<>(false, ResponseMsg.GET_FAIL.getMsg());
    }

    /**
     * 绑定权限
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse relateRights(RoleRelateRightRequest request) {
        //先解绑所有权限
        int result = mapper.unrelateRoleAllRightByRoleId(request.getRoleId());
        List<Long> rightIds = Arrays.asList(request.getRightIds());

        //绑定权限
        Map map = new HashMap();
        map.put("roleId",request.getRoleId());
        map.put("list",rightIds);
        mapper.relateRights(map);
        return new BaseResponse(true,"操作成功");
    }

    /**
     * 获取已关联用户
     *
     * @param request
     * @return
     */
    @Override
    public BasePageResponse queryRelatedUsers(RoleRelatedUserPageRequest request) {
        Map map = new HashMap();
        map.put("roleId",request.getRoleId());
        map.put("type",1);//查找关联用户
        Page<Object> page = PageHelper.startPage(request.getStart(),
                request.getLength());
        List<User> users = mapper.queryUsersByRoleId(map);
        List<UserResponse> responses = new ArrayList<>(users.size());
        ConvertUtil.listObjectToListObject(users,responses,UserResponse.class);
        return new BasePageResponse(request.getDraw(),page.getTotal(),responses);
    }

    /**
     * 获取未关联用户
     *
     * @param request
     * @return
     */
    @Override
    public BasePageResponse queryUnrelatedUsers(RoleRelatedUserPageRequest request) {
        Map map = new HashMap();
        map.put("roleId",request.getRoleId());
        map.put("type",2);//查找未关联用户
        Page<Object> page = PageHelper.startPage(request.getStart(),
                request.getLength());
        List<User> users = mapper.queryUsersByRoleId(map);
        List<UserResponse> responses = new ArrayList<>(users.size());
        ConvertUtil.listObjectToListObject(users,responses,UserResponse.class);
        return new BasePageResponse(request.getDraw(),page.getTotal(),responses);
    }

    /**
     * 关联用户
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse relateUsers(RoleRelateUserRequest request) {
        return null;
    }

    /**
     * 解除关联用户
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse unrelateUsers(RoleRelateUserRequest request) {
        return null;
    }
}
