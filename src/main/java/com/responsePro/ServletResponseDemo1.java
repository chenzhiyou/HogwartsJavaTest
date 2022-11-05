package com.responsePro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/ServletResponseDemo1", value = "/ServletResponseDemo1")
public class ServletResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取参数
        String username = request.getParameter("username");
        System.out.println("ServletResponseDemo1 username: "+ username);
        // 2、响应结果给客户端
//        PrintWriter writer = response.getWriter();
//        writer.write("hello: "+ username);
        // 共享数据
        request.setAttribute("data", 100);
        // 重定向 设置重定向状态码，注意：重定向的时候一定要写项目访问路径
        response.setStatus(302);
        response.setHeader("location", "/javaCourse_war_exploded/ServletResponseDemo2");

        // 设置重定向的第二种方式
        response.sendRedirect("/javaCourse_war_exploded/ServletResponseDemo2");
    }
}
