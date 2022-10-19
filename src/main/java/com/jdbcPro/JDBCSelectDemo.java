package com.jdbcPro;

import java.sql.*;

public class JDBCSelectDemo {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            String url = "jdbc:mysql://localhost:3306/tulingDB"; // 链接数据库的URL
            String username = "root";
            String password = "3158218k@";
            connection = DriverManager.getConnection(url, username, password);
            // 获取执行SQL的对象
            statement = connection.createStatement();
            // 执行SQL并获取结果集
            resultSet = statement.executeQuery("select * from pserson");
            // 处理结果
            while (resultSet.next()){
                // 一列一列获取
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String sex = resultSet.getString("sex");
                System.out.println(id+ "-" + name + "-"+ age+ "-"+ sex);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
