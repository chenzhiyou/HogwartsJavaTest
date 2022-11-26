package com.myfruits.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        // 1、 获取参数
        String methodStr = request.getParameter("method");
        // 如果method==null，统一跳转到首页
        if (methodStr == null || methodStr.equals("")){
            methodStr = "index";
        }
        // 2、 通过反射的技术调用方法
        // 获取class类对象
        Class clazz = this.getClass();
        // 获取方法
        try {

            Method method = clazz.getMethod(methodStr, HttpServletRequest.class, HttpServletResponse.class);
            Object result = method.invoke(this, request, response);
            if (result != null){
                String resultStr = (String)result;
                // 对结果进行处理
                if (resultStr.indexOf("forward:") !=-1){
                    // forward
                    String path = resultStr.substring(resultStr.indexOf(":") + 1);
                    request.getRequestDispatcher(path).forward(request, response);
                }else if (resultStr.indexOf("redirect:") !=-1){
                    // 重定向
                    String path = resultStr.substring(resultStr.indexOf(":") + 1);
                    response.sendRedirect(request.getContextPath()+path);
                }else {
                    // 直接响应回字符串
                    response.getWriter().println(resultStr);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    /**
     *  统一重定向到首页
     * @param request
     * @param response
     * @return
     */
    public String index(HttpServletRequest request, HttpServletResponse response){
        return "redirect:/index.jsp";
    }

}
