package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletCookieDemo2", value = "/ServletCookieDemo2")
public class ServletCookieDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取其他servlet共享的数据
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie: cookies){
            String name = cookie.getName();
            String value = cookie.getValue();

            // 删除cookie
            if(cookie.equals("data")){
                cookie.setMaxAge(0);
                cookie.setValue("newzhangsaan");
                response.addCookie(cookie);
            }
            System.out.println(name + ": "+ value);
        }

    }
}
