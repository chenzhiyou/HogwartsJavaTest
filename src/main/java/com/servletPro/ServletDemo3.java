package com.servletPro;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

// 使用注解的方式进行配置
@WebServlet(name = "servletDemo3", value = "/servletDemo3", loadOnStartup = 1)
public class ServletDemo3 extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("ServletDemo3 service.....");
    }
}
