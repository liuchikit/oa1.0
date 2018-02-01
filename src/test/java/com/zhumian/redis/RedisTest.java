package com.zhumian.redis;

import com.zhumian.BaseTest;
import com.zhumian.service.sys.UserService;
import com.zhumian.vo.req.sys.user.UserSaveOrUpdateRequest;
import com.zhumian.vo.res.BaseResponse;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/14 11:10
 */
public class RedisTest extends BaseTest{

    @Resource
    private UserService userService;

    @Test
    public void save(){
        UserSaveOrUpdateRequest request = new UserSaveOrUpdateRequest();
        request.setId(10L);
        request.setAccount("account");
        request.setName("name");
        userService.save(request);
    }

    @Test
    public void getById(){
        BaseResponse res = userService.getResById(10L);
        System.out.println(res);
    }

    @Test
    public void delete(){
        userService.delete(10L);
    }
}
