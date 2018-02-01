package com.zhumian.service.sys;

import com.zhumian.entity.sys.Role;
import com.zhumian.service.BaseService;
import com.zhumian.vo.req.sys.role.RolePageRequest;
import com.zhumian.vo.req.sys.role.RoleRelateRightRequest;
import com.zhumian.vo.req.sys.role.RoleSaveOrUpdateRequest;
import com.zhumian.vo.res.BasePageResponse;
import com.zhumian.vo.res.BaseResponse;
import com.zhumian.vo.res.sys.RoleResponse;

/**
 * @author zhumian
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

}
