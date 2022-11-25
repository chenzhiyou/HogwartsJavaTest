package com.myfruits.controller;

import com.myfruits.domain.User;
import com.myfruits.service.UserService;
import com.myfruits.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/userServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、获取参数
        String method = request.getParameter("method");
        // 2、根据标识做不同的处理
        if (method.equals("login")){// 登录请求
            login(request, response);
        }else if (method.equals("register")){ // 注册
            register(request, response);
        }

    }

    /**
     * 登录
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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


    /**
     * 注册
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
    }
}
