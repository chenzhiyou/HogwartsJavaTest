package com.mymovie.entity;

import lombok.Data;

import java.util.Date;

@Data
public class OrderInfo {
    private String orderId;
    private long userId;
    private long scheduleId;
    private String orderPosition;
    private Integer orderState;
    private Integer orderPrice;
    private Date orderTime;
}
