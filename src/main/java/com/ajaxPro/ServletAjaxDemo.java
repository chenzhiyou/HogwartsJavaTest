package com.ajaxPro;

import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "/ServletAjaxDemo", value = "/ServletAjaxDemo")
public class ServletAjaxDemo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求的参数
        String username = request.getParameter("username");
        System.out.println("username: "+ username);

        // 模拟其他操作
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 创建一个Java对象
        Person p = new Person();
        p.setSex("男");
        p.setName("张三");
        p.setAge(23);
        // 将Java对象转成Json返回给前端
        String string = JSON.toJSONString(p);

        response.getWriter().write(string);
    }
}
