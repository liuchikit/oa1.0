package com.liuchikit.mapper.sys;

import com.liuchikit.entity.sys.Role;
import com.liuchikit.entity.sys.User;
import com.liuchikit.vo.req.sys.role.RoleRelateRightRequest;
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

    /**
     * 根据角色ID查找用户
     * @param map
     * @return
     */
    List<User> queryUsersByRoleId(Map map);

    /**
     * 关联用户
     * @param map
     * @return
     */
    int relateUsers(Map map);

    /**
     * 关解除联用户
     * @param map
     * @return
     */
    int unrelateUsers(Map map);
}
