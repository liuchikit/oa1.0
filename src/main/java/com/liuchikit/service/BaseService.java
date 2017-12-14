package com.liuchikit.service;


import com.liuchikit.vo.res.BaseResponse;

import java.io.Serializable;
import java.util.List;

/**
 * {类说明}
 *
 * @author liaozijie
 * @date 2017/11/15
 */
public interface BaseService<T extends Serializable,PK extends Serializable> {

    /**
     * 根据主键获取实体
     * @param pk
     * @return
     */
    T get(PK pk);

    /**
     *根据主键获取实体
     * @param pk
     * @return
     */
    T getById(PK pk);

    /**
     *根据条件返回实体
     * @param filter
     * @return
     */
    T getOne(T filter);

    /**
     * 获取所有实体列表
     * @return
     */
    List<T> findAll();

    /**
     * 根据条件获取实体列表
     * @param filter
     * @return
     */
    List<T>findByParams(T filter);

    /**
     *
     * @param filter
     * @param isFuzzyQueryOpened 是否开启模糊查询
     * @return
     */
    List<T>findByParams(T filter, boolean isFuzzyQueryOpened);

    /**
     * 保存实体
     * @param t
     * @return
     */
    BaseResponse<T> save(T t);

    /**
     * 批量保存实体
     * @param l
     * @return
     */
    BaseResponse<T> saveAll(List<T> l);

    /**
     * 更新实体
     * @param t
     * @return
     */
    BaseResponse<T> update(T t);

    /**
     * 删除实体
     * @param t
     * @return
     */
    BaseResponse<Void> delete(T t);

    /**
     * 根据ID删除实体
     * @param pk
     * @return
     */
    BaseResponse<Void> deleteById(PK pk);


}
