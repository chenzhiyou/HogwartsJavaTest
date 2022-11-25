package com.myfruits.controller;

import com.myfruits.domain.User;
import com.myfruits.service.UserService;
import com.myfruits.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "/RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private UserService  userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取参数
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String pwd1 = request.getParameter("pwd1");
        // 2、封装到一个实体类
        User user = new User(email, phone, pwd1, email);
        // 3、调用业务逻辑层去处理
        User loginUser = userService.add(user);
        if (loginUser != null){
            HttpSession session = request.getSession();
            session.setAttribute("user", loginUser);
            response.sendRedirect(request.getContextPath()+"/index.jsp");
        }else {
            request.getRequestDispatcher("/reg.jsp").forward(request, response);
        }

        // 4、根据结果响应前端

    }
}
