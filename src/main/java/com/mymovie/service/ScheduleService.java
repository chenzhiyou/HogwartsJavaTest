package com.mymovie.service;

import com.mymovie.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleService {
    /**
     * 根据电影ID和影院ID查询场次信息
     * @param movieId
     * @param cinemaId
     * @return
     */
    List<Schedule> findScheduleByMovieAndCinema(long movieId, long cinemaId);

}
