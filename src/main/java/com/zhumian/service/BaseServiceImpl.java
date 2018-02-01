package com.zhumian.service;

import com.zhumian.constant.ResponseMsg;
import com.zhumian.util.ExampleUtil;
import com.zhumian.vo.res.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * {类说明}
 *
 * @author liaozijie
 * @date 2017/11/15
 */
public abstract class BaseServiceImpl<T extends Serializable,PK extends Serializable> implements BaseService<T,PK>{

    private static Logger logger = LoggerFactory.getLogger(BaseServiceImpl.class);

    protected Mapper<T> mapper;
    protected Class entityClass;

    public abstract void setMapper(Mapper<T> mapper);

    public BaseServiceImpl(){
        //当前对象的直接超类Type
        Type type = getClass().getGenericSuperclass();
        if (!(type instanceof ParameterizedType)) { // 如果Service类被包装代理类的话
            type = getClass().getSuperclass().getGenericSuperclass();
        }
        //参数化类型
        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
        this.entityClass = (Class<T>) trueType;
    }

    /**
     * 根据主键获取实体
     *
     * @param pk
     * @return
     */
    public T get(PK pk) {
        return getById(pk);
    }

    /**
     * 根据主键获取实体
     *
     * @param pk
     * @return
     */
    public T getById(PK pk) {
        return mapper.selectByPrimaryKey(pk);
    }

    /**
     * 根据条件返回实体
     *
     * @param filter
     * @return
     */
    public T getOne(T filter) {
        return mapper.selectOne(filter);
    }

    /**
     * 获取所有实体列表
     *
     * @return
     */
    public List<T> findAll() {
        return mapper.selectAll();
    }

    /**
     * 根据条件获取实体列表,默认开启模糊查询
     *
     * @param filter
     * @return
     */
    public List<T> findByParams(T filter) {
        Example example = ExampleUtil.createExample(filter,true,this.entityClass);
        return mapper.selectByExample(example);
    }

    /**
     * @param filter
     * @param isFuzzyQueryOpened 是否开启模糊查询
     * @return
     */
    @Override
    public List<T> findByParams(T filter, boolean isFuzzyQueryOpened) {
        Example example = ExampleUtil.createExample(filter,isFuzzyQueryOpened,this.entityClass);
        return mapper.selectByExample(example);
    }

    @Override
    public BaseResponse<T> save(T t) {
        int i =  mapper.insertSelective(t);
        if(i > 0){
            return new BaseResponse<>(true, ResponseMsg.SAVE_SUCCESS.getMsg());
        }else {
            return new BaseResponse<>(false, ResponseMsg.SAVE_FAIL.getMsg());
        }
    }

    @Override
    public BaseResponse<T> saveAll(List<T> l) {
        // TODO: 2017/12/3  
        l.forEach(t -> save(t));
        return null;
    }

    @Override
    public BaseResponse<T> update(T t) {
       int i = mapper.updateByPrimaryKeySelective(t);
        if(i > 0){
            return new BaseResponse<>(true, ResponseMsg.UPDATE_SUCCESS.getMsg());
        }else {
            return new BaseResponse<>(false, ResponseMsg.UPDATE_FAIL.getMsg());
        }
    }

    @Override
    public BaseResponse<Void> delete(T t) {
        return null;
    }

    @Override
    public BaseResponse<Void> deleteById(PK pk) {
        int i = mapper.deleteByPrimaryKey(pk);
        if(i > 0){
            return new BaseResponse<>(true, ResponseMsg.DEL_SUCCESS.getMsg());
        }else {
            return new BaseResponse<>(false, ResponseMsg.DEL_FAIL.getMsg());
        }
    }


}
