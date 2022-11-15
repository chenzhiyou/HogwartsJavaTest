package com.mymovie.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    private long commentId; //评论ID
    private long userId; // 用户ID
    private String commentContent; // 评论内容
    private long movieId; // 电影ID
    private Date commentTime; // 评论时间
    private User commentUser; // 评论用户
}
