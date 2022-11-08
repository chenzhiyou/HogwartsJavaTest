package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/ServletRegister", value = "/ServletRegister")
public class ServletRegister extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        // 调用业务逻辑层处理结果
        if ("admin".equals(username) && "123".equals(password)){
            // 登录成功 保存用户的登录信息
            session.setAttribute("username", "admin");
            response.sendRedirect("/javaCourse_war_exploded/ServletMiddle");
        }else {
            PrintWriter writer = response.getWriter();
            writer.write("用户名或者密码错误，请重新登录");
        }

    }
}
