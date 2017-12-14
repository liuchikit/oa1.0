package com.liuchikit.service.sys.impl;

import com.liuchikit.constant.ResponseMsg;
import com.liuchikit.entity.sys.Right;
import com.liuchikit.entity.sys.Role;
import com.liuchikit.entity.sys.User;
import com.liuchikit.mapper.sys.UserMapper;
import com.liuchikit.service.BaseServiceImpl;
import com.liuchikit.service.sys.UserService;
import com.liuchikit.util.ConvertUtil;
import com.liuchikit.vo.req.LoginRequest;
import com.liuchikit.vo.req.sys.user.QueryRolesOrRightsRequest;
import com.liuchikit.vo.req.sys.user.UserSaveOrUpdateRequest;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RoleResponse;
import com.liuchikit.vo.res.sys.right.RightResponse;
import com.liuchikit.vo.res.sys.user.UserResponse;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,Long> implements UserService{

    @Resource(name = "userMapper")
    private UserMapper mapper;

    @Resource(name = "userMapper")
    @Override
    public void setMapper(Mapper<User> mapper) {
        super.mapper = mapper;
    }

    @Override
    public BaseResponse login(LoginRequest request, HttpServletRequest servletRequest) {
        User userSearcher = new User();
        ConvertUtil.objectToObject(request,userSearcher,true);
        User user = mapper.selectOne(userSearcher);
        if(user != null){
            HttpSession session = servletRequest.getSession();
            session.setAttribute("user",user);
            return new BaseResponse();
        }
        return new BaseResponse(false,"登录失败");
    }

    /**
     * 根据用户ID查询角色列表
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse<List<RoleResponse>> queryRolesByUser(QueryRolesOrRightsRequest request) {
        Map map = new HashMap();
        ConvertUtil.objectToMap(request,map);
        List<Role> roles = mapper.queryRolesByUser(map);
        List<RoleResponse> responses = new ArrayList<>(roles.size());
        ConvertUtil.listObjectToListObject(roles,responses,RoleResponse.class);
        return new BaseResponse(responses);
    }

    /**
     * 根据用户查询权限列表
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse<List<RightResponse>> queryRightsByUser(QueryRolesOrRightsRequest request) {
        Map map = new HashMap();
        ConvertUtil.objectToMap(request,map);
        List<Right> rights = mapper.queryRightsByUser(map);
        List<RightResponse> responses = new ArrayList<>(rights.size());
        ConvertUtil.listObjectToListObject(rights,responses,RightResponse.class);
        return new BaseResponse(responses);
    }

    /**
     * 保存
     *
     * @param request
     * @return
     */
    @Override
    @CachePut(value = "redis",key = "'user:save' + #request.account")
    public BaseResponse save(UserSaveOrUpdateRequest request) {
        System.out.println("save");
        User user = new User();
        ConvertUtil.objectToObject(request,user,true,true,true);
        return save(user);
    }

    /**
     * 更新
     *
     * @param request
     * @return
     */
    @Override
    public BaseResponse update(UserSaveOrUpdateRequest request) {
        System.out.println("update");
        User user = new User();
        ConvertUtil.objectToObject(request,user,true,false,true);
        return update(user);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public BaseResponse delete(Long id) {
        System.out.println("delete");
        return deleteById(id);
    }

    @Override
    @Cacheable(value = "redis",key = "'user:getResById' + #id")
    public BaseResponse getResById(Long id) {
        System.out.println("getResById");
        User user = getById(id);
        if(user != null){
           UserResponse response = new UserResponse();
           ConvertUtil.objectToObject(user,response,true);
           return new BaseResponse(response);
        }
        return new BaseResponse(false, ResponseMsg.GET_FAIL.getMsg());
    }
}
