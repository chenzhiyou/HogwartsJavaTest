package com.myfruits.dao.impl;

import com.myfruits.dao.UserDao;
import com.myfruits.domain.User;
import com.myfruits.util.DBUtils;
import com.myfruits.util.DruidUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    @Override
    public int add(User user) throws SQLException {
        // 1、 获取数据库连接
        Connection connection = DruidUtils.getConnection();
        PreparedStatement preparedStatement = null;
        // 2、 获取执行SQL语句对象
        String sql = "insert into user(email, phone, pwd, uname) values (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            // 设置参数
            preparedStatement.setString(1,user.getEmail());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getPwd());
            preparedStatement.setString(4, user.getUname());
            // 执行
            int row = preparedStatement.executeUpdate();
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.closeAll(connection, preparedStatement, null);
        }
        return 0;
    }

    @Override
    public User findByStr(String str) throws SQLException {
        // 1、 获取数据库连接
//        Connection connection = DBUtils.getConnection();
        // 使用数据库连接池的方式来建立连接
        Connection connection = DruidUtils.getConnection();
        PreparedStatement preparedStatement = null;
        User user =null;
        try {
            String sql = "select id, email,pwd, phone, username from user where email = ? or phone = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, str);
            preparedStatement.setString(2, str);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String pwd = resultSet.getString("pwd");
                String phone = resultSet.getString("phone");
                String username = resultSet.getString("username");
                user = new User(id, email, pwd, phone, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DruidUtils.closeAll(connection, preparedStatement, null);
        }
        return user;
    }
}
