package org.example.webmagament.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {
    @Override  //初始化方法，只调用一次
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("执行初始化方法");
    }

    @Override  //拦截到请求后调用，可调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("放行前逻辑");
        //放行
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("放行后逻辑");
    }

    @Override  //销毁方法，只调用一次
    public void destroy() {
        System.out.println("执行销毁方法");
    }
}
