package com.requestPro;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "/ServletRequestDemo3", value = "/ServletRequestDemo3")
public class ServletRequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] loves = request.getParameterValues("love");
        System.out.println("username: "+ username);
        System.out.println("password: "+ password);
        System.out.println("love: "+ Arrays.toString(loves));
        System.out.println("========================");
        // 获取所有请求的参数名称
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()){
            String paramName = parameterNames.nextElement();
            String[] parameterValues = request.getParameterValues(paramName);
            System.out.println(paramName + ":" + Arrays.toString(parameterValues));
        }
        System.out.println("========================");
        // 获取所有参数的map集合
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry: entries){
            System.out.println(entry.getKey()+ ": "+ Arrays.toString(entry.getValue()));
        }

    }
}
