package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletCookieDemo1", value = "/ServletCookieDemo1")
public class ServletCookieDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 创建cookie
        Cookie cookie = new Cookie("data", "ZhangSan");
        // 设置有效期
        cookie.setMaxAge(30);
        // 通过response发送数据到客户端
        response.addCookie(cookie);
    }
}
