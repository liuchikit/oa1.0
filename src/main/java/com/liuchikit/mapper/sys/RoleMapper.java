package com.liuchikit.mapper.sys;

import com.liuchikit.entity.sys.Role;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMapper extends Mapper<Role> {

    /**
     * 角色解绑所有权限
     * @param roleId
     * @return
     */
    int unrelateRoleAllRightByRoleId(Long roleId);

    /**
     * 绑定权限
     * @param map
     * @return
     */
    int relateRights(Map map);
}
