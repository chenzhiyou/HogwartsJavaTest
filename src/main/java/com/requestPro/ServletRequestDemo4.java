package com.requestPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletRequestDemo4", value = "/ServletRequestDemo4")
public class ServletRequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        System.out.println("ServletRequestDemo4 username: "+ username);
        // 数据共享
        String msg = (String) request.getAttribute("msg");
        System.out.println("获取到的共享数据"+ msg);
    }
}
