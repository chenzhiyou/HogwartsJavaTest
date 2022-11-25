package com.myfruits.controller;

import com.myfruits.domain.User;
import com.myfruits.service.UserService;
import com.myfruits.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 邮箱或者手机号
        String str = request.getParameter("str");
        String pwd = request.getParameter("pwd");
        // 调用业务逻辑层
        User loginUser = userService.login(str, pwd);
        if (loginUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }
}
