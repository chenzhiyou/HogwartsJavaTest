package com.mymovie.service.impl;

import com.mymovie.entity.*;
import com.mymovie.mapper.*;
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
    @Autowired
    private OrderMapper orderMapper;

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

    @Override
    public Schedule findScheduleById(long scheduleId) {
        Schedule schedule = scheduleMapper.findScheduleById(scheduleId);
        Hall hall = hallMapper.findHallById(schedule.getHallId());
        // 根据放映厅里面的影院ID进行查询
        Cinema cinema = cinemaMapper.findCinemaByCinemaId(hall.getCinemaId());
        hall.setHallCinema(cinema);
        // 设置放映厅对象
        schedule.setScheduleHall(hall);
        // 设置一个电影的对象
        Movie movie= movieMapper.findMovieById(schedule.getMovieId());
        schedule.setScheduleMovie(movie);
        // 根据场次的ID查询订单列表
        List<OrderInfo> orderInfoList = orderMapper.findOrdersByScheduleId(scheduleId);
        schedule.setOrderList(orderInfoList);
        return schedule;
    }
}
