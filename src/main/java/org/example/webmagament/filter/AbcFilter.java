package org.example.webmagament.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override  //拦截到请求后调用，可调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Abc放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("Abc放行后逻辑");
    }
}

