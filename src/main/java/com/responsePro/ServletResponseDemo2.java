package com.responsePro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/ServletResponseDemo2", value = "/ServletResponseDemo2")
public class ServletResponseDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取参数
        String username = request.getParameter("username");
        System.out.println("ServletResponseDemo2 username: "+ username);

        // 获取共享的数据
        String data = (String) request.getAttribute("data");
        System.out.println("获取Request中共享的数据" + data);
        // 解决响应乱码问题
        response.setCharacterEncoding("utf-8");
        // 不推荐
//        response.setHeader("Content-type", "text/html;charset=utf-8");
        // 推荐使用的方式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();

        writer.write("重定向处理完毕， 返回浏览器");
    }
}
