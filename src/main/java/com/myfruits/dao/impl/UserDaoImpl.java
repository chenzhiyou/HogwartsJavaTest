package com.myfruits.dao.impl;

import com.myfruits.dao.UserDao;
import com.myfruits.domain.User;
import com.myfruits.util.DBUtils;
import com.myfruits.util.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
    @Override
    public int add(User user)  {
        // 1、 获取数据库连接
//        Connection connection = DruidUtils.getConnection();
//        PreparedStatement preparedStatement = null;
//        // 2、 获取执行SQL语句对象
//        String sql = "insert into user(email, phone, pwd, uname) values (?,?,?,?)";
//        try {
//            preparedStatement = connection.prepareStatement(sql);
//            // 设置参数
//            preparedStatement.setString(1,user.getEmail());
//            preparedStatement.setString(2, user.getPhone());
//            preparedStatement.setString(3, user.getPwd());
//            preparedStatement.setString(4, user.getUname());
//            // 执行
//            int row = preparedStatement.executeUpdate();
//            return row;
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DruidUtils.closeAll(connection, preparedStatement, null);
//        }
//        return 0;
        String sql = "insert into user(email, phone, pwd, uname) values (?,?,?,?)";
        Object[] params= {user.getEmail(), user.getPhone(), user.getPwd(), user.getUname()};
        int row = 0;
        try {
            row = queryRunner.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return row;

    }

    @Override
    public User findByStr(String str)  {
        // 1、 获取数据库连接
//        Connection connection = DBUtils.getConnection();
        // 使用数据库连接池的方式来建立连接
//        Connection connection = DruidUtils.getConnection();
//        PreparedStatement preparedStatement = null;
//        User user =null;
//        try {
//            String sql = "select id, email,pwd, phone, username from user where email = ? or phone = ?";
//            preparedStatement = connection.prepareStatement(sql);
//            preparedStatement.setString(1, str);
//            preparedStatement.setString(2, str);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String email = resultSet.getString("email");
//                String pwd = resultSet.getString("pwd");
//                String phone = resultSet.getString("phone");
//                String username = resultSet.getString("username");
//                user = new User(id, email, pwd, phone, username);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            DruidUtils.closeAll(connection, preparedStatement, null);
//        }
//        return user;
        String sql = "select id, email,pwd, phone, username from user where email = ? or phone = ?";
        Object[] params = {str, str};
        User user = null;
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }

    @Override
    public List<User> findAll() {
        String sql = "select * from user";
        List<User> userList = null;
        try {
            userList = queryRunner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public User findUserById(int id) {
        String sql = "select * from user where id=?";
        Object[] params = {id};
        User user = new User();
        try {
            user = queryRunner.query(sql, new BeanHandler<User>(User.class), params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public int updateUserInfo(User user) {
        String sql = "update user set email=?, phone=?, pwd=?,username=? where id=?";
        Object[] params = {user.getEmail(), user.getPhone(),
                user.getPwd(), user.getUname()};
        try {
            int update = queryRunner.update(sql, params);
            return update;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteUser(int id) {
        String sql = "delete from user where id=?";
        Object[] params = {id};
        try {
            int row = queryRunner.update(sql, params);
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
