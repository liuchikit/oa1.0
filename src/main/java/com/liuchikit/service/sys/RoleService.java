package com.liuchikit.service.sys;

import com.liuchikit.entity.sys.Role;
import com.liuchikit.service.BaseService;
import com.liuchikit.vo.req.sys.role.*;
import com.liuchikit.vo.res.BasePageResponse;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.RoleResponse;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/8 11:47
 */
public interface RoleService extends BaseService<Role,Long> {

    /**
     * 保存
     * @return
     */
    BaseResponse save(RoleSaveOrUpdateRequest request);

    /**
     * 更新
     * @return
     */
    BaseResponse update(RoleSaveOrUpdateRequest request);

    /**
     * 分页查询
     * @return
     */
    BasePageResponse list(RolePageRequest rolePageRequest);

    /**
     * 逻辑删除
     * @return
     */
    BaseResponse deleteById(Long id);

    /**
     *
     * @param id
     * @return
     */
    BaseResponse<RoleResponse> getResById(Long id);

    /**
     * 绑定权限
     * @param request
     * @return
     */
    BaseResponse relateRights(RoleRelateRightRequest request);

    /**
     * 获取已关联用户
     * @param request
     * @return
     */
    BasePageResponse queryRelatedUsers(RoleRelatedUserPageRequest request);

    /**
     * 获取未关联用户
     * @param request
     * @return
     */
    BasePageResponse queryUnrelatedUsers(RoleRelatedUserPageRequest request);

    /**
     * 关联用户
     * @param request
     * @return
     */
    BaseResponse relateUsers(RoleRelateUserRequest request);

    /**
     * 解除关联用户
     * @param request
     * @return
     */
    BaseResponse unrelateUsers(RoleRelateUserRequest request);

}
