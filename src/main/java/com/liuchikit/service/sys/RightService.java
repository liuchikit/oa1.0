package com.liuchikit.service.sys;

import com.liuchikit.entity.sys.Right;
import com.liuchikit.service.BaseService;
import com.liuchikit.vo.req.sys.right.RightSaveOrUpdateRequest;
import com.liuchikit.vo.res.BaseResponse;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/11 21:40
 */
public interface RightService extends BaseService<Right,Long>{

    /**
     * 保存
     * @param request
     * @return
     */
    BaseResponse save(RightSaveOrUpdateRequest request);

    /**
     * 更新
     * @param request
     * @return
     */
    BaseResponse update(RightSaveOrUpdateRequest request);

    /**
     * 获取实体
     * @param id
     * @return
     */
    BaseResponse getResById(Long id);

    /**
     * 查询权限
     * @param type
     * @return
     */
    BaseResponse queryRights(Integer type);

    /**
     * 根据type清空缓存
     * @param type
     */
    void clearCache(Integer type);


}
