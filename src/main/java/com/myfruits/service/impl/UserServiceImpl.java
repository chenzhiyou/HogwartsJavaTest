package com.myfruits.service.impl;

import com.myfruits.dao.UserDao;
import com.myfruits.dao.impl.UserDaoImpl;
import com.myfruits.domain.User;
import com.myfruits.service.UserService;

import java.sql.SQLException;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 添加用户
     * @param user
     * @return
     * @throws SQLException
     */
    @Override
    public User add(User user) {
        int add = 0;
        try {
            add = userDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (add ==1){
            User loginUser = login(user.getEmail(), user.getPwd());
            return loginUser;
        }
        return null;
    }

    /**
     * 用户登录
     * @param str
     * @param pwd
     * @return
     * @throws SQLException
     */
    @Override
    public User login(String str, String pwd)  {
        User user = null;
        try {
            user = userDao.findByStr(str);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user.getPwd().equals(pwd)){
            user.setPwd("******");
            return user;
        }
        return null;
    }
}
