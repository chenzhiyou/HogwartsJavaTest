package com.mymovie.service;

import com.mymovie.entity.OrderInfo;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoService {

    /**
     * 生成订单
     * @param scheduleId
     * @param position
     * @param price
     * @return
     */
    Integer addOrder(OrderInfo orderInfo);
}
