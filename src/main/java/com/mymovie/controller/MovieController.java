package com.mymovie.controller;

import com.alibaba.fastjson.JSONObject;
import com.mymovie.entity.Cinema;
import com.mymovie.entity.Movie;
import com.mymovie.service.CinemaService;
import com.mymovie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieServices;
    @Autowired
    private CinemaService cinemaService;

    @RequestMapping("/findAllMovies")
    @ResponseBody
    public JSONObject finaAllMovies(){
        JSONObject jsonObject = new JSONObject();
        // 调用业务逻辑层，查询列表
        // 热映列表
        List<Movie> hotMovies = movieServices.findAllMovies(1);// 1表示在线，0表示下架
        // 即将上映列表
        List<Movie> upComingMovies = movieServices.findAllMovies(0);

        // 根据票房进行排序
        List<Movie> sortList = movieServices.sortMovieByBoxOffice();

        // 根据热门进行排序
        List<Movie> movies = movieServices.sortMovieByCommentCount();

        // 根据上映时间进行排序
        movieServices.sortMovieByReleaseDate();
        jsonObject.put("data", hotMovies);
        jsonObject.put("data1", upComingMovies);
        jsonObject.put("sort", sortList);
        return jsonObject;
    }

    @RequestMapping("/sortAllMovies")
    @ResponseBody
    public JSONObject sortAllMovies(String order){
        JSONObject jsonObject = new JSONObject();
        // 调用业务层获取查询列表
        List<Movie> list = new ArrayList<>();
        switch (order){
            case "热门":
                list = movieServices.sortMovieByCommentCount();
                break;
            case "时间":
                list = movieServices.sortMovieByReleaseDate();
                break;
            case "评价":
                list = movieServices.sortMovieByScore();
                break;
        }

        jsonObject.put("data", list);
        jsonObject.put("count", list.size());
        return jsonObject;
    }

    @RequestMapping("/findMoviesByType")
    @ResponseBody
    public JSONObject findMoviesByType(String type){
        JSONObject jsonObject = new JSONObject();
        // 调用业务层获取查询列表
        List<Movie> moviesByType = movieServices.findMoviesByType(type);

        jsonObject.put("data", moviesByType);
        jsonObject.put("count", moviesByType.size());
        return jsonObject;
    }

    @RequestMapping("/findMovieById")
    @ResponseBody
    public JSONObject findMovieById(Integer movie_id){
        JSONObject jsonObject = new JSONObject();
        Movie movieById = movieServices.findMovieById(movie_id);
        // 查询影院列表
        List<Cinema> cinemaList = cinemaService.findCinemasByMovieId(movie_id);

        jsonObject.put("data", movieById);
        jsonObject.put("cinemaList", cinemaList);
        return jsonObject;
    }

}
