package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletSessionDemo2", value = "/ServletSessionDemo2")
public class ServletSessionDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }   

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session
        HttpSession session = request.getSession();
        String data = (String) session.getAttribute("data");
        System.out.println("session范围共享的数据data: "+ data);
    }
}
