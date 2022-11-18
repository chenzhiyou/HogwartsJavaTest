package com.mymovie.service.impl;

import com.mymovie.entity.User;
import com.mymovie.mapper.UserMapper;
import com.mymovie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServicesImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String userName, String userPwd) {
        List<User> userList = userMapper.findUserByName(userName);
        if (userList !=null && userList.size() >0){
            for (User user: userList){
                if (userPwd.equals(user.getUserPwd())){
                    return user;
                }
            }
        }
        return null;
    }

    @Override
    public List<User> findUserByName(String userName) {
        return userMapper.findUserByName(userName);
    }

    @Override
    public Integer register(User user) {
        return userMapper.addUser(user);
    }
}
