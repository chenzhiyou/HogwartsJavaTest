package com.myfruits.controller;

import com.myfruits.domain.Shop;
import com.myfruits.service.CartService;
import com.myfruits.service.impl.CartSerViceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.spi.CharsetProvider;

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

}
