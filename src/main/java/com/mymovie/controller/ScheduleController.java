package com.mymovie.controller;

import com.alibaba.fastjson.JSONObject;
import com.mymovie.entity.Schedule;
import com.mymovie.service.ScheduleService;
import com.mymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;


    @RequestMapping("/findScheduleByCinemaAndMovie")
    @ResponseBody
    public JSONObject findScheduleByCinemaAndMovie(@RequestParam("cinema_id")long cinemaId, @RequestParam("movie_id")long movieId){
        JSONObject jsonObject = new JSONObject();
        List<Schedule> scheduleList = scheduleService.findScheduleByMovieAndCinema(movieId, cinemaId);
        jsonObject.put("data", scheduleList);
        return jsonObject;
    }

    @RequestMapping("/findScheduleById")
    @ResponseBody
    public JSONObject findScheduleById(@RequestParam("schedule_id") long scheduleId){
        JSONObject jsonObject = new JSONObject();
        Schedule schedule  = scheduleService.findScheduleById(scheduleId);
        jsonObject.put("data", schedule);
        return jsonObject;
    }
}
