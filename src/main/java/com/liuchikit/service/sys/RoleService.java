package com.liuchikit.service.sys;

import com.liuchikit.entity.sys.Role;
import com.liuchikit.service.BaseService;
import com.liuchikit.vo.req.sys.RolePageRequest;
import com.liuchikit.vo.req.sys.RoleSaveOrUpdateRequest;
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

}
