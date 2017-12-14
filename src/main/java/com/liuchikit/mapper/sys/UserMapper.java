package com.liuchikit.mapper.sys;

import com.liuchikit.entity.sys.Right;
import com.liuchikit.entity.sys.Role;
import com.liuchikit.entity.sys.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper extends Mapper<User> {

    /**
     * 根据用户查询角色列表
     * @param map
     * @return
     */
    List<Role> queryRolesByUser(Map map);

    /**
     * 根据用户查询权限列表
     * @param map
     * @return
     */
    List<Right> queryRightsByUser(Map map);
}
