package com.example.demo.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//拦截器
public class JwtInterceptor implements HandlerInterceptor {

    @Override
    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler ) throws Exception{
        String token= request.getHeader("token");
        //如果不是映射到方法直接通过
    return false;
    }
}
