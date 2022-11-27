package com.myfruits.controller;

import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;
import com.myfruits.service.CartService;
import com.myfruits.service.FruitService;
import com.myfruits.service.impl.CartSerViceImp;
import com.myfruits.service.impl.FruitServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "/fruitServlet", value = "/fruitServlet")
public class FruitServlet extends BaseServlet {

    private FruitService fruitService = new FruitServiceImpl();
    private CartService cartService = new CartSerViceImp();

//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String method = request.getParameter("method");
//        if (method.equals("hot")){
//            hot(request, response); // 热卖列表
//        }else if (method.equals("info")){// 根据水果查询详情
//            info(request, response);
//        }
//    }

    /**
     * 热卖专区
     * @param request
     * @param response
     */
    public void hot(HttpServletRequest request, HttpServletResponse response){
        List<Fruit> fruits = fruitService.findHot();
        request.setAttribute("fruits", fruits);
    }

    /**
     * 根据水果的查询详情
     * @param request
     * @param response
     */
    public String info(HttpServletRequest request, HttpServletResponse response){
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        Fruit fruit = fruitService.findById(fid);
        request.setAttribute("fruit", fruit);
        //
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);
        if (uid!=0){
            Shop shop = cartService.find(uid, fid);
            if ( shop != null) {
                if (shop.isCart()){
                    request.setAttribute("tit1", "已加入购物车");
                }
                if (shop.isStar()){
                    request.setAttribute("tit2", "已关注");
                }
            }
        }
        hot(request, response);
        // 3、转发到水果页面详情
//        try {
//            request.getRequestDispatcher("/fruit_info.jsp").forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "forward:/fruit_info.jsp";
    }
}
