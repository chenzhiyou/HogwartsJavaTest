package com.mymovie.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Movie {
    private long movieId;
    private String movieCnName; // 电影名称
    private String movieFgName; // 电影英文名称
    private String movieActor; // 电影演职人员
    private String movieDirector; // 电影导演
    private String movieDetail; // 电影详情
    private String movieDuration;// 电影时长
    private String movieType; // 电影类型
    private float movieScore; // 电影评分
    private float movieBoxOffice; //电影票房
    private long movieCommentCount; // 电影参评人数
    private Date movieReleaseDate; // 电影上映时间
    private String movieCountry; // 电影制片地区
    private String moviePicture; // 电影海报
    private int movieState; // 电影状态
    private List<Comment> CommentList; // 电影评论

}
