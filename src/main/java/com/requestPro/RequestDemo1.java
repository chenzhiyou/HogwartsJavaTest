package com.requestPro;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/requestDemo1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws SecurityException, IOException{
        // 获取请求行的信息
        String method = request.getMethod();
        System.out.println("请求方式："+ method);
        // 项目访问路径
        String contextPath = request.getContextPath();
        System.out.println("项目访问路径"+ contextPath);
        String servletPath = request.getServletPath();
        System.out.println("servletPath: "+ servletPath);
        // get请求参数
        String queryString = request.getQueryString();
        System.out.println("get请求参数: "+ queryString);

        // 获取请求的URI
        String requestURI = request.getRequestURI();
        System.out.println("requestURI: "+ requestURI);
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("requestURL: "+ requestURL);

        String protocol = request.getProtocol();
        System.out.println("协议的版本： "+ protocol);

        String remoteAddr = request.getRemoteAddr();
        System.out.println("地址： "+ remoteAddr);


    }
}
