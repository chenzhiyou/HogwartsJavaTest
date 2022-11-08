package com.cookieSessionPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletSessionDemo1", value = "/ServletSessionDemo1")
public class ServletSessionDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session对象
        HttpSession session = request.getSession();
        // 共享数据
        session.setAttribute("data", "zhoujielun");
        System.out.println(session.getId());

        // 设置session的超时时间
        session.setMaxInactiveInterval(10);

    }

}
