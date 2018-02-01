package com.zhumian.aspect;

import com.zhumian.entity.sys.User;
import com.zhumian.vo.req.BaseRequest;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/16 9:53
 */
@Order(2)
@Aspect
@Component
public class BaseRequestAspect {



    @Pointcut("execution(* com.zhumian.controller..*.*(..)) &&  args(request, ..)")
    public void aspectMethod(BaseRequest request){

    }

    @Before("aspectMethod(request)")
    public void before(JoinPoint joinPoint, BaseRequest request){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
        if(user != null){
            Date now = new Date();
            request.setUpadterId(user.getId());
            request.setUpdater(user.getName());
            request.setUpdateTime(now);

            if(request.getCreatorId() == null){
                request.setCreatorId(user.getId());
                request.setCreator(user.getName());
                request.setCreateTime(now);
            }
        }

    }
}
