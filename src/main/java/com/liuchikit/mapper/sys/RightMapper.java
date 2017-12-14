package com.liuchikit.mapper.sys;

import com.liuchikit.entity.sys.Right;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface RightMapper extends Mapper<Right> {


    List<Right> queryRights(Map map);
}
