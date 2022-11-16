package com.mymovie.entity;

import lombok.Data;

@Data
public class Hall {
    private long hallId;
    private String hallName;
    private Integer hallCapacity;
    private long cinemaId;
}
