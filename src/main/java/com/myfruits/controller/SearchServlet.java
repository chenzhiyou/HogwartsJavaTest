package com.myfruits.controller;

import com.myfruits.domain.Fruit;
import com.myfruits.service.FruitService;
import com.myfruits.service.impl.FruitServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/searchServlet", value = "/searchServlet")
public class SearchServlet extends BaseServlet {

    private FruitService fruitService = new FruitServiceImpl();
    /**
     * 根据关键字搜索
     * @param request
     * @param response
     * @return
     */
   public String search(HttpServletRequest request, HttpServletResponse response){
        // 1、 获取参数
       String keyWord = request.getParameter("keyword");
       // 2、调用业务逻辑层
       if (keyWord !=null || keyWord.equals("")){
           // 查询全部商品
            all(request, response);
       }
       List<Fruit> fruitList = fruitService.findByStr(keyWord);
       request.setAttribute("selFruits", fruitList);
       // 转发
       return "forward:/search.jsp";
   }
   public String all(HttpServletRequest request, HttpServletResponse response){
       // 获取参数
       String key = request.getParameter("");
       // 调用业务逻辑层
       List<Fruit> all = fruitService.findAll();
       request.setAttribute("selFruits", all);
       return "forward:/search.jsp";
   }
}
