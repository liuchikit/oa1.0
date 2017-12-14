package com.liuchikit.controller.sys;

import com.liuchikit.entity.sys.User;
import com.liuchikit.service.sys.UserService;
import com.liuchikit.vo.req.LoginRequest;
import com.liuchikit.vo.res.BaseResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author liuchikit
 * @Description
 * @date 2017/12/4 20:47
 */
@RestController
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public BaseResponse login(LoginRequest request,HttpServletRequest servletRequest){
        /*return userService.login(request,servletRequest);*/
        UsernamePasswordToken token = new UsernamePasswordToken(request.getAccount(),request.getPassword());
        Subject currentUser = SecurityUtils.getSubject();
        if(!currentUser.isAuthenticated()){
            token.setRememberMe(false);
            currentUser.login(token);
        }
        return new BaseResponse();

    }

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        User user = (User)session.getAttribute("user");
        ModelAndView mav =  new ModelAndView("home");
        mav.addObject("user",user);
        return mav;
    }
}
