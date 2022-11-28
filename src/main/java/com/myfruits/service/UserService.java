package com.myfruits.service;

import com.myfruits.domain.User;

import java.sql.SQLException;
import java.util.List;

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

    /**
     * 获取用户列表
     * @return
     */
    List<User> findAll();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Boolean updateUserInfo(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    Boolean deleteUser(int id);
}
