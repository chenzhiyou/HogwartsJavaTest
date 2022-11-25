package com.myfruits.service;

import com.myfruits.domain.User;

import java.sql.SQLException;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    User add(User user);

    /**
     * 登录用户名和密码登录
     * @param str
     * @return
     */
    User login(String str, String pwd);
}
