package com.myfruits.controller;

import com.myfruits.domain.Fruit;
import com.myfruits.domain.Shop;
import com.myfruits.domain.User;
import com.myfruits.service.CartService;
import com.myfruits.service.impl.CartSerViceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.spi.CharsetProvider;
import java.util.List;

@WebServlet(name = "/cartServlet")
public class CartServlet extends BaseServlet {

    private CartService cartService = new CartSerViceImp();

    /**
     * 添加购物车
     * @return
     */
    public String addCart(HttpServletRequest request, HttpServletResponse response){
        // 1、获取参数
        String uidStr = request.getParameter("uid");
        String fidStr = request.getParameter("fid");
        String str = request.getParameter("str");
        int uid = Integer.parseInt(uidStr);
        int fid = Integer.parseInt(fidStr);
        if (uid != 0){// 说明已经登录
            Shop shop = cartService.find(uid, fid);
            if (shop == null){// 不存在购物车项
                shop = new Shop();
                shop.setUid(uid);
                shop.setFid(fid);
                if ("cart".equals(str)){// 加入购物车
                    shop.setCart(true);
                    shop.setStar(false);
                }else if ("star".equals(str)){// 添加关注
                    shop.setCart(false);
                    shop.setStar(true);
                }
                cartService.add(uid, shop);
            }else{// 已经存在，进行信息的更新
                if ("cart".equals(str)){// 加入购物车
                    shop.setCart(true);
                    shop.setStar(shop.isCart());
                }else if ("star".equals(str)){// 添加关注
                    shop.setCart(shop.isCart());
                    shop.setStar(true);
                }
                cartService.update(uid,shop);

            }
            return "froward:/fruitServlet?method=info&uid="+uid+"&fid="+fid;
        }else {// 说明没有登录，需要跳转到登录界面进行登录
            request.setAttribute("showError", true);
            return "forward:/login.jsp";
        }
    }


    /**
     * 显示我的购物车和我的关注列表
     * @param request
     * @param response
     * @return
     */
    public String show(HttpServletRequest request, HttpServletResponse response){
        // 1、获取参数
        String uidStr = request.getParameter("uid");
        // 根据boob来判断是显示购物车还是关注列表
        String boob = request.getParameter("boob");
        int uid = Integer.parseInt(uidStr);
        boolean flag = false;
        if ("cart".equals(boob)){
            flag = true;
        }
        if (uid!=0){ // 已登录
            // 2、调用业务逻辑层
            if (flag){
                List<Fruit> fruits = cartService.show(uid, flag);
                request.setAttribute("fruits", fruits);
                return "forward:/showcart.jsp";
            }else {
                List<Fruit> fruits = cartService.show(uid, flag);
                request.setAttribute("fruits", fruits);
                return "forward:/showstar.jsp";
            }
        }else {// 说明没有登录，需要跳转到登录界面进行登录
            request.setAttribute("showError", true);
            return "forward:/login.jsp";
        }
    }

    /**
     * 获取购物车中商品的数量
     * @param request
     * @param response
     */
    public void num(HttpServletRequest request, HttpServletResponse response){
        // 1、获取登录用户
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        int num = 0;
        if (user!=null){
            List<Shop> carts = cartService.findByUid(user.getId());
            num = carts.size();
        }
        request.setAttribute("num", num);
    }


    /**
     * 删除购物车或者取消关注
     * @param request
     * @param response
     * @return
     */
    public String del(HttpServletRequest request, HttpServletResponse response){
        // 1、 获取参数
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);
        String fidStr = request.getParameter("fid");
        int fid = Integer.parseInt(fidStr);
        String str = request.getParameter("str");
        Shop shop = new Shop();
        shop.setUid(uid);
        shop.setFid(fid);
        // 2、调用业务逻辑层
        if (uid != 0){
            // (1)从数据库里面查询存在的记录
            Shop returnShop = cartService.find(uid, fid);
            if ("cart".equals(str)){// 购物车列表的删除
                shop.setCart(false);
                shop.setStar(returnShop.isStar());
            }
            else if ("star".equals(str)){// 关注列表的删除
                shop.setCart(returnShop.isCart());
                shop.setStar(false);
            }
            if (shop.isStar() || shop.isStar()){ // 假设有关注或者添加购物车，那么就更新
                 cartService.update(uid, shop);
            }else {// 杀菌除
                cartService.del(uid, fid);
            }
            if ("cart".equals(str)){
                return "forward:/cartServlet?method=show&uid="+uid+"&boob=star";
            }else{
                return "forward:/cartServlet?method=show&uid="+uid+"&boob=star";
            }
        }else{
            request.setAttribute("showError", true);
            return "forward:/login.jsp";
        }

    }
}
