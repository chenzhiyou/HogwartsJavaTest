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
}
