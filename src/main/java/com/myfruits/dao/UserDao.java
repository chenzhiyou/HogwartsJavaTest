package com.myfruits.dao;

import com.myfruits.domain.User;

import java.sql.SQLException;

public interface UserDao {
    // 添加用户
    int add(User user) throws SQLException;

    /**
     * 根据条件查询
     * @param str
     * @return
     */
    User findByStr(String str) throws SQLException;
}
