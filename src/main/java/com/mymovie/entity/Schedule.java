package com.mymovie.entity;

import lombok.Data;

@Data
public class Schedule {
    private long scheduleId;
    private long hallId;
    private long movieId;
    private String scheduleStartTime;
    private Integer schedulePrice;
    private Integer scheduleRemain;
    private Integer scheduleState;
}
