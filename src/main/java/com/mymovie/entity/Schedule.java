package com.mymovie.entity;

import lombok.Data;

import java.util.List;

/**
 * 电影场次
 */
@Data
public class Schedule {
    private long scheduleId;
    private long hallId;
    private long movieId;
    private String scheduleStartTime;
    private int schedulePrice;
    private int scheduleRemain;
    private int scheduleState;
    private List<OrderInfo> orderList; // 所有的订单集合
    private Hall scheduleHall; // 所属放映对象
    private Movie scheduleMovie; // 放映的电影
}
