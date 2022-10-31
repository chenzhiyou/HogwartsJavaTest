package com.servletPro;

import javax.servlet.*;
import java.io.IOException;

/**
 * 当第一次访问servlet的时候，会初始化Servlet实例，而且只执行一次
 * ServletConfig：获取配置
 * service 提供服务的方法，也就是真正处理请求，返回响应的方法，每次请求都会调用一次
 * destroy 销毁的方法，也就是Tomcat正常停止的时候，会在销毁Servlet实例之前调用
 */
public class ServletDemo2 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init().............");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service().............");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy().............");
    }
}
