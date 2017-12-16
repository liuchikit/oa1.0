package com.liuchikit.service;

import com.liuchikit.vo.res.BaseResponse;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/13 23:28
 */
public interface RedisService {

    /**
     * 新建缓存
     * @param key
     * @param value
     * @param expire
     * @return
     */
    BaseResponse cachePut(String key,String value,long expire);

    /**
     * 得到缓存
     * @param key
     * @return
     */
    BaseResponse cacheGet(String key);

    /**
     * 删除缓存
     * @param key
     * @return
     */
    BaseResponse cacheDelete(String key);
}
