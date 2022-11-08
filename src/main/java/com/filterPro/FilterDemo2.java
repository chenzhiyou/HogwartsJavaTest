package com.filterPro;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "FilterDemo2", value = "/ServletFilterDemo1")
public class FilterDemo2 implements Filter {
    /**
     * 初始化方法，只执行1次
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init......");
    }

    /**
     * 每一次请求被拦截资源时，会执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter......");
    }

    /**
     * 销毁
     */
    @Override
    public void destroy() {
        System.out.println("destroy......");
   }
}
