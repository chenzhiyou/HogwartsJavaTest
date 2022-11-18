package com.mymovie.service.impl;

import com.mymovie.entity.Cinema;
import com.mymovie.entity.Hall;
import com.mymovie.entity.Schedule;
import com.mymovie.mapper.CinemaMapper;
import com.mymovie.mapper.HallMapper;
import com.mymovie.mapper.ScheduleMapper;
import com.mymovie.service.CinemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CinemaServiceImpl implements CinemaService {

    @Autowired
    private CinemaMapper cinemaMapper;

    @Autowired
    private HallMapper hallMapper;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    public List<Cinema> findCinemasByMovieId(long movieId) {
        List<Cinema> cinemas = cinemaMapper.findCinemasByMovieId(movieId);
        if (cinemas !=null && cinemas.size()>0){
            for (Cinema cinema: cinemas){
                // 根据影院的ID查询放映厅的列表
                List<Hall> hallList = hallMapper.findHallByCinemaId(cinema.getCinemaId());
                // 根据电影ID和影院的ID 查询场次的列表
                List<Schedule> scheduleList = scheduleMapper.findScheduleByMovieAndCinema(movieId, cinema.getCinemaId());
                cinema.setScheduleList(scheduleList);
                cinema.setHallList(hallList);
            }
        }
        return cinemas;
    }
}
