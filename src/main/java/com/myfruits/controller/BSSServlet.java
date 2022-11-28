package com.myfruits.controller;

import com.myfruits.domain.User;
import com.myfruits.service.UserService;
import com.myfruits.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/BSSServlet", value = "/BSSServlet")
public class BSSServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 跳转到后台管理的首页
     * @param request
     * @param response
     * @return
     */
    public String toAdmin(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){// 登录状态
            return "redirect:/BSindex.jsp";
        }else{// 跳转到登录页
            return "forward:/login.jsp";
        }
    }

    public String alluser(HttpServletRequest request, HttpServletResponse response){
        List<User> all = userService.findAll();
        request.setAttribute("allusers", all);
        return "forward:/allUser.jsp";
    }

    /**
     * 后台添加用户功能
     * @param request
     * @param response
     * @return
     */
    public String adduser(HttpServletRequest request, HttpServletResponse response){
        // 1、获取参数
        String name1 = request.getParameter("name1");
        String email1 = request.getParameter("email1");
        String phone1 = request.getParameter("phone1");
        String pwd1 = request.getParameter("pwd1");
        
        User user = new User(name1, email1, phone1, pwd1);
        // 2、调用业务逻辑层
        User addUser = userService.add(user);

        if (addUser != null){
            return alluser(request, response);
        }

        return null;
    }
}
