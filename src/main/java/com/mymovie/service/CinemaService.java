package com.mymovie.service;

import com.mymovie.entity.Cinema;
import com.mymovie.entity.Hall;

import java.util.List;

public interface CinemaService {
    /**
     * 根据电影ID查询一个影院的集合
     * @param movieId
     * @return
     */
    List<Cinema> findCinemasByMovieId(long movieId);
}
