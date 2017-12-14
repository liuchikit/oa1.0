package com.liuchikit.service.sys;

import com.liuchikit.entity.sys.User;
import com.liuchikit.service.BaseService;
import com.liuchikit.vo.req.LoginRequest;
import com.liuchikit.vo.req.sys.user.QueryRolesOrRightsRequest;
import com.liuchikit.vo.req.sys.user.UserSaveOrUpdateRequest;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RoleResponse;
import com.liuchikit.vo.res.sys.right.RightResponse;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends BaseService<User,Long> {

    /**
     * 登录
     * @param request
     * @return
     */
    BaseResponse login(LoginRequest request, HttpServletRequest servletRequest);

    /**
     * 根据用户查询角色列表
     * @param request
     * @return
     */
    BaseResponse<List<RoleResponse>> queryRolesByUser(QueryRolesOrRightsRequest request);

    /**
     * 根据用户查询权限列表
     * @param request
     * @return
     */
    BaseResponse<List<RightResponse>> queryRightsByUser(QueryRolesOrRightsRequest request);

    /**
     * 保存
     * @param request
     * @return
     */
    BaseResponse save(UserSaveOrUpdateRequest request);

    /**
     * 更新
     * @param request
     * @return
     */
    BaseResponse update(UserSaveOrUpdateRequest request);

    /**
     * 删除
     * @param id
     * @return
     */
    BaseResponse delete(Long id);

    BaseResponse getResById(Long id);
}
