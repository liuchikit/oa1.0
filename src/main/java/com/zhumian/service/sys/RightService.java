package com.zhumian.service.sys;

import com.zhumian.entity.sys.Right;
import com.zhumian.service.BaseService;
import com.zhumian.vo.req.sys.right.RightQueryRequest;
import com.zhumian.vo.req.sys.right.RightSaveOrUpdateRequest;
import com.zhumian.vo.res.BaseResponse;

/**
 * @author zhumian
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
     * @param request
     * @return
     */
    BaseResponse queryRights(RightQueryRequest request);

    /**
     * 根据type清空缓存
     * @param type
     */
    void clearCache(Integer type);


}
