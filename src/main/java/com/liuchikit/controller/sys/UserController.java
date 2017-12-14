package com.liuchikit.controller.sys;

import com.liuchikit.service.sys.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

@RestController
@RequestMapping("sys/user")
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping(value = "/toRegister",method = RequestMethod.GET)
    public ModelAndView toRegister(){
        return new ModelAndView("/user/register");
    }

}
