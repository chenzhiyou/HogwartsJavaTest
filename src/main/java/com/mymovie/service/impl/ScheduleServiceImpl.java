package com.mymovie.service.impl;

import com.mymovie.entity.Cinema;
import com.mymovie.entity.Hall;
import com.mymovie.entity.Movie;
import com.mymovie.entity.Schedule;
import com.mymovie.mapper.CinemaMapper;
import com.mymovie.mapper.HallMapper;
import com.mymovie.mapper.MovieMapper;
import com.mymovie.mapper.ScheduleMapper;
import com.mymovie.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;
    @Autowired
    private HallMapper hallMapper;
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private MovieMapper movieMapper;

    @Override
    public List<Schedule> findScheduleByMovieAndCinema(long movieId, long cinemaId) {
        List<Schedule> scheduleList = scheduleMapper.findScheduleByMovieAndCinema(movieId, cinemaId);
        if (scheduleList !=null && scheduleList.size() >0){
            for (Schedule schedule: scheduleList){
                // 根据场次的放映厅的ID
                Hall hall = hallMapper.findHallById(schedule.getHallId());
                // 根据放映厅里面的影院ID进行查询
                Cinema cinema = cinemaMapper.findCinemaByCinemaId(hall.getCinemaId());
                hall.setHallCinema(cinema);
                // 设置放映厅对象
                schedule.setScheduleHall(hall);
                // 设置一个电影的对象
                Movie movie= movieMapper.findMovieById(movieId);
                schedule.setScheduleMovie(movie);
            }
        }
        return scheduleList;
    }
}
