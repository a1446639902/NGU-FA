






package com.yidu.permission.controller;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;





/**
 * 过滤器
 */





@Component
@WebFilter("*")
public class FAWebFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强转为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //强转为HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        System.out.println("Filter coming");
        //获取session
        HttpSession session = request.getSession(false);
        if (session==null){
            session = request.getSession();
        }
        //释放静态资源 和 以登录以后的资源
        if (request.getRequestURI().startsWith("/css")
        ||request.getRequestURI().startsWith("/fonts")
        ||request.getRequestURI().startsWith("/images")
        ||request.getRequestURI().startsWith("/js")
        ||request.getRequestURI().startsWith("/lib")
        ||request.getRequestURI().equals("/user/checkLogin")
        ||request.getRequestURI().equals("/fund/selectFund")
        ||request.getRequestURI().equals("/page/login")
        ||session.getAttribute("userName")!=null){
            filterChain.doFilter(request,response);
        }else if (request.getRequestURI().contains("/page/page/login")){
            response.sendRedirect("../login");
        } else {
            response.sendRedirect("./page/login");
        }
    }

    @Override
    public void destroy() {

    }
}



