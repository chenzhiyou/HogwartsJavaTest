package com.mymovie.entity;

import lombok.Data;

import java.util.List;

/**
 * 电影院
 */
@Data
public class Cinema {
    private long cinemaId;
    private String cinemaName;
    private String cinemaAddress;
    private List<Hall> hallList; // 所有的放映厅的集合
    private List<Schedule> scheduleList; // 所有场次的集合
 }
