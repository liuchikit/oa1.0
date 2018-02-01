package com.zhumian.filter;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhumian
 * @Description
 * @date 2017/12/9 21:15
 */
public class EmptyStringFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        //只是我们自己写的param参数去除空格并写回的类
        EmptyStringWrapper emptyStringWrapper = new EmptyStringWrapper(httpServletRequest);
        filterChain.doFilter(emptyStringWrapper, httpServletResponse);
    }
}
