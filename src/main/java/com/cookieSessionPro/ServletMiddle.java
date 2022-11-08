package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/ServletMiddle", value = "/ServletMiddle")
public class ServletMiddle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session共享的信息
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        PrintWriter writer = response.getWriter();
        writer.write("欢迎您: "+ username);

    }
}
