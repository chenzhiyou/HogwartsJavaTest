package com.mymovie.mapper;

import com.mymovie.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User findUserById(long userId);

    /**
     * 根据用户名进行查询
     * @param userName
     * @return
     */
    List<User> findUserByName(String userName);

    /**
     * 注册
     * @param user
     * @return
     */
    Integer addUser(User user);
}
