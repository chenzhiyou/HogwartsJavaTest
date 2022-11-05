package com.requestPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletRequestDemo5", value = "/ServletRequestDemo5")
public class ServletRequestDemo5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String username = request.getParameter("username");
        System.out.println("ServletRequestDemo5 username: "+ username);
        // 数据共享
        request.setAttribute("msg", "hello");
        // 请求转发, 转发是一次请求
        // 重定向是两次请求
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ServletRequestDemo4");
        requestDispatcher.forward(request, response);


    }
}
