package com.mymovie.service.impl;

import com.mymovie.entity.OrderInfo;
import com.mymovie.mapper.OrderMapper;
import com.mymovie.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Integer addOrder(OrderInfo orderInfo) {
        return orderMapper.addOrder(orderInfo);
    }
}
