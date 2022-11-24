package com.myfruits.dao;

import com.myfruits.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    // 添加用户
    int add(User user) throws SQLException;

    /**
     * 根据条件查询
     * @param str
     * @return
     */
    User findByStr(String str) throws SQLException;

    /**
     * 获取用户列表
     * @return
     */
    public List<User> findAll();

    /**
     * 根据用户ID查询记录
     * @param id
     * @return
     */
    public User findUserById(int id);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    public int updateUserInfo(User user);

    /**
     * 删除用户信息
     * @param id
     * @return
     */
    public int deleteUser(int id);
}
