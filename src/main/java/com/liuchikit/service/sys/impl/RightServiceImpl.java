package com.liuchikit.service.sys.impl;

import com.liuchikit.constant.ResponseMsg;
import com.liuchikit.entity.sys.Right;
import com.liuchikit.entity.sys.RightVO;
import com.liuchikit.entity.sys.User;
import com.liuchikit.mapper.sys.RightMapper;
import com.liuchikit.service.BaseServiceImpl;
import com.liuchikit.service.sys.RightService;
import com.liuchikit.util.ConvertUtil;
import com.liuchikit.vo.req.sys.right.RightQueryRequest;
import com.liuchikit.vo.req.sys.right.RightSaveOrUpdateRequest;
import com.liuchikit.vo.res.BaseResponse;
import com.liuchikit.vo.res.sys.right.RightResponse;
import com.liuchikit.vo.res.sys.right.TreeViewResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/11 22:20
 */
@Service
public class RightServiceImpl extends BaseServiceImpl<Right,Long> implements RightService {

    private final static Logger logger = LoggerFactory.getLogger(RightServiceImpl.class);

    @Resource
    private RightMapper mapper;

    @Resource(name = "rightMapper")
    @Override
    public void setMapper(Mapper<Right> mapper) {
        super.mapper = mapper;
    }

    /**
     * 保存
     *
     * @param request
     * @return
     */
    @Override
    @CachePut(value = "redis",key = "'right:save' + #request.getRightCode()")
    public BaseResponse save(RightSaveOrUpdateRequest request) {
        Right right = new Right();
        ConvertUtil.objectToObject(request,right,true,true,true);
        return save(right);
    }

    /**
     * 更新
     *
     * @param request
     * @return
     */
    @Override
    @CachePut(value = "redis",key = "'right:save' + #request.getRightCode()")
    public BaseResponse update(RightSaveOrUpdateRequest request) {
        Right right = new Right();
        ConvertUtil.objectToObject(request,right,true,false,true);
        return update(right);
    }

    /**
     * 获取实体
     *
     * @param id
     * @return
     */
    @Override
    public BaseResponse getResById(Long id) {
        Right right = getById(id);
        if(right != null){
            RightResponse response = new RightResponse();
            ConvertUtil.objectToObject(right,response,true);
            return new BaseResponse(response);
        }
        return new BaseResponse(false, ResponseMsg.GET_FAIL.getMsg());
    }

    /**
     * 查询权限
     *
     * @param request
     * @return
     */
    @Override
    @Cacheable(value = "redis",key = "'right:' + #request")
    public BaseResponse queryRights(RightQueryRequest request) {
        Session session = SecurityUtils.getSubject().getSession();
        User user = (User)session.getAttribute("user");
        Map map = new HashMap();

        //查询所有权限
        if(Objects.equals(request.getType(),1)){
            map.put("level",0);
        }
        //查询菜单树
        if(Objects.equals(request.getType(),2)){
            map.put("level",1);
            map.put("userId",user.getId());
            map.put("rightType",1);
        }
        //查询用户所有权限
        if(Objects.equals(request.getType(),3)){
            map.put("level",0);
            //若有传入用户ID，则根据用户ID查询权限，否则根据当前登录用户ID查询权限
            map.put("userId",request.getUserId() == null ? user.getId() : request.getUserId());
        }
        //查询角色所有权限
        if(Objects.equals(request.getType(),4)){
            map.put("level",0);
            map.put("roleId",request.getRoleId());
        }

        List<RightVO> rights = mapper.queryRights(map);
        List<TreeViewResponse> trees = new ArrayList<>();
        for(RightVO right : rights){
            TreeViewResponse tree = new TreeViewResponse();
            tree.setId(right.getId());
            tree.setText(right.getRightName());
            tree.setUrl(right.getRightCode());

            //查询用户权限时设置勾选状态
            if(Objects.equals(request.getType(),3)){
                if(!Objects.equals(right.getUserID(),null)){
                    tree.setChecked(1);
                }
            }
            //查询角色权限时设置勾选状态
            if(Objects.equals(request.getType(),4)){
                if(!Objects.equals(right.getRoleId(),null)){
                    tree.setChecked(1);
                }
            }
            //设置父权限ID
            request.setPid(right.getId());
            tree.setNodes(querySubRights(request));
            trees.add(tree);
        }
        return new BaseResponse(trees);
    }

    private List<TreeViewResponse> querySubRights(RightQueryRequest request){
        Map map = new HashMap();
        //查询菜单
        if(Objects.equals(request.getType(),2)){
            map.put("userId",request.getUserId());
            map.put("rightType",1);
        }
        //查询用户权限
        if(Objects.equals(request.getType(),3)){
            map.put("userId",request.getUserId());
        }
        //查询角色权限
        if(Objects.equals(request.getType(),4)){
            map.put("roleId",request.getRoleId());
        }

        map.put("pid",request.getPid());
        List<RightVO> rights =  mapper.queryRights(map);
        List<TreeViewResponse> trees = new ArrayList<>();
        for(RightVO right : rights){
            TreeViewResponse tree = new TreeViewResponse();
            tree.setId(right.getId());
            tree.setText(right.getRightName());
            tree.setUrl(right.getRightCode());
            //查询用户权限时设置勾选状态
            if(Objects.equals(request.getType(),3)){
                if(!Objects.equals(right.getUserID(),null)){
                    tree.setChecked(1);
                }
            }
            //查询角色权限时设置勾选状态
            if(Objects.equals(request.getType(),4)){
                if(!Objects.equals(right.getRoleId(),null)){
                    tree.setChecked(1);
                }
            }
            //设置父权限ID
            request.setPid(right.getId());
            tree.setNodes(querySubRights(request));
            trees.add(tree);
        }
        return trees;
    }

    /**
     * 根据type清空缓存
     *
     * @param type
     */
    @Override
    @CacheEvict(value="redis",key="'right:clearCache' + #type")
    public void clearCache(Integer type) {
        logger.debug("清空 type：" + type + "的缓存");
    }
}
