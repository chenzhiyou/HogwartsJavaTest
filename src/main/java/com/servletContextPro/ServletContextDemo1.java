package com.servletContextPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletContextDemo1", value = "/ServletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、首先获取到ServletContext,两种获取方式
        ServletContext servletContext = this.getServletContext();
        ServletContext servletContext1 = request.getServletContext();
        // 2、共享数据
        Integer count = (Integer) servletContext.getAttribute("count");
        if (count == null){
            servletContext.setAttribute("count", 1);
            count =1;
        }else {
            count++;
            servletContext.setAttribute("count", count);
        }
        // 将访问的次数响应到前端页面上
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("应用被访问了"+ count+ " 次");

        //获取项目的真实路径(物理路径)
        System.out.println("relaPath: "+ servletContext.getRealPath("/"));
    }
}
