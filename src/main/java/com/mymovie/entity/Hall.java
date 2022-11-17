package com.mymovie.entity;

import lombok.Data;

import java.util.List;

/**
 * 放映厅
 */
@Data
public class Hall {
    private long hallId;
    private String hallName;
    private int hallCapacity;
    private long cinemaId;
    private List<Schedule> scheduleList; // 放映厅场次的集合
    private Cinema hallCinema; // 所属电影院
}
