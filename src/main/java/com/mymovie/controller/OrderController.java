package com.mymovie.controller;

import com.alibaba.fastjson.JSONObject;
import com.mymovie.entity.OrderInfo;
import com.mymovie.entity.User;
import com.mymovie.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderInfoService order;

    @RequestMapping("/buyTickets")
    @ResponseBody
    public JSONObject buyTickets(@RequestParam("schedule_id") long scheduleId,
                                 @RequestParam("position[]") String[] position, Integer price,
                                 HttpServletRequest request){
        JSONObject jsonObject = new JSONObject();
        // 获取登录用户
        User user = (User) request.getSession().getAttribute("user");
        String orderPosition = null;
        if (user == null){ // 未登录
            jsonObject.put("code", 200);
            jsonObject.put("msg", "未登录，请先登录");
        }else {
            if (position !=null && position.length >0){
                int done = 0;
                Integer orderPrice = price/ position.length;
                for (int i = 0; i < position.length; i++){
                    // 可以生成一个订单
                    OrderInfo orderInfo = new OrderInfo();
                    // 生成订单编号
                    long orderId = System.currentTimeMillis();
                    long userId = user.getUserId();
                    orderPosition = position[i];
                    // 进行订单信息的组装
                    orderInfo.setOrderId(orderId+"");
                    orderInfo.setUserId(userId);
                    orderInfo.setOrderPosition(orderPosition);
                    orderInfo.setOrderPrice(orderPrice);
                    orderInfo.setOrderTime(new Date()); // 当前时间
                    orderInfo.setScheduleId(scheduleId);
                    Integer add = order.addOrder(orderInfo);
                    if (add == 1){
                        done ++;
                    }
                }
                if (done == position.length){
                    jsonObject.put("code", 0);
                    jsonObject.put("msg", "购票成功");
                }else {
                    jsonObject.put("code", 100);
                    jsonObject.put("msg", "购票失败");
                }
            }
        }
        return jsonObject;

    }
}
