package com.myfruits.test;

import com.myfruits.dao.UserDao;
import com.myfruits.dao.impl.UserDaoImpl;
import com.myfruits.domain.User;

import java.sql.SQLException;

public class TestDemo {
    public static void main(String[] args) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        User user = new User();
        user.setEmail("11@qq.com");
        user.setPhone("13120015359");
        user.setPwd("123");
        user.setUname("xxxx");
        userDao.add(user);
    }
}
