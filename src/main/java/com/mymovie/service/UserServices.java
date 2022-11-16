package com.mymovie.service;

import com.mymovie.entity.User;

import java.util.List;

public interface UserServices {

    /**
     * 登录
     * @param userName
     * @param userPwd
     * @return
     */
    User login(String userName, String userPwd);

    /**
     * 根据用户名查询是否存在
     * @param userName
     * @return
     */
    List<User> findUserByName(String userName);

    /**
     * 注册功能
     * @param user
     * @return
     */
    Integer register(User user);
}
