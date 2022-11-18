package com.mymovie.mapper;

import com.mymovie.entity.Hall;

import java.util.List;

public interface HallMapper {

    /**
     * 根据影院获取放映厅的集合
     * @param cinemaId
     * @return
     */
    List<Hall> findHallByCinemaId(long cinemaId);
}
