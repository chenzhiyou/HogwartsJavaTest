package com.filterPro;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 使用注解的方式
 */
@WebFilter(filterName = "FilterDemo1", value = "/ServletFilterDemo1")
public class FilterDemo1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 真正过滤的代码
        System.out.println("过滤器在访问servlet之前执行了。。。。。");
        // 放行代码
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("过滤器在访问servlet之后执行了。。。。。");
    }

    @Override
    public void destroy() {
    }
}
