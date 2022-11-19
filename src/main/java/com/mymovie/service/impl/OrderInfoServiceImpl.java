package com.mymovie.service.impl;

import com.mymovie.entity.OrderInfo;
import com.mymovie.mapper.OrderMapper;
import com.mymovie.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<OrderInfo> findOrdersByScheduleId(long scheduleId) {
        return orderMapper.findOrdersByScheduleId(scheduleId);
    }
}
