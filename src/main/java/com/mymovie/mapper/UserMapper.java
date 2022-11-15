package com.mymovie.mapper;

import com.mymovie.entity.User;

public interface UserMapper {
    /**
     * 根据ID查询用户
     * @param userId
     * @return
     */
    User findUserById(long userId);
}
