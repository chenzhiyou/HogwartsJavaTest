package com.mymovie.mapper;

import com.mymovie.entity.OrderInfo;

import java.util.List;

public interface OrderMapper {
    /**
     * 根据场次信息查询订单信息
     * @param scheduleId
     * @return
     */
    List<OrderInfo> findOrdersByScheduleId(long scheduleId);

}
