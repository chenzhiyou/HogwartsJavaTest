package com.ajaxPro;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "/ServletRegisterDemo", value = "/ServletRegisterDemo")
public class ServletRegisterDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        Map map = new HashMap<>();
        if ("zhangsan".equals(username)){
            map.put("isExsits", true);
            map.put("msg", "此用户名太受欢迎，请更换一个");
        }else{
            map.put("isExsits", false);
            map.put("msg", "用户名可用");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String string = objectMapper.writeValueAsString(map);
        response.getWriter().write(string);
    }
}
