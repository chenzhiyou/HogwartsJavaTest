package com.mymovie.service;

import com.mymovie.entity.OrderInfo;

import java.util.List;

public interface OrderInfoService {
    /**
     * 根据场次信息查询订单信息
     * @param scheduleId
     * @return
     */
    List<OrderInfo> findOrdersByScheduleId(long scheduleId);
}
