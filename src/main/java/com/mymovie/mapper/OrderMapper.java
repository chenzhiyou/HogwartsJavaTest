package com.mymovie.mapper;

import com.mymovie.entity.OrderInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderMapper {
    /**
     * 根据场次信息查询订单信息
     * @param scheduleId
     * @return
     */
    List<OrderInfo> findOrdersByScheduleId(long scheduleId);

    /**
     * 生成订单
     * @param orderInfo
     * @return
     */
    Integer addOrder(OrderInfo orderInfo);
}
