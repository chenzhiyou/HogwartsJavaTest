package com.mymovie.mapper;

import com.mymovie.entity.Schedule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScheduleMapper {

    List<Schedule> findScheduleByMovieAndCinema(@Param("movieId") long movieId, @Param("cinemaId") long cinemaId);
}
