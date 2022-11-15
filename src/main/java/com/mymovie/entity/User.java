package com.mymovie.entity;

import lombok.Data;

@Data
public class User {
    private long userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private Integer userRole;
    private String userHeadImg;
}
