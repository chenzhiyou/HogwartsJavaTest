package com.mymovie.mapper;

import com.mymovie.entity.Cinema;

import java.util.List;

public interface CinemaMapper {

    /**
     * 根据电影ID查询一个影院的集合
     * @param movieId
     * @return
     */
    List<Cinema> findCinemasByMovieId(long movieId);
}
