package com.jdbcPro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 1、注册驱动
//        Class.forName("com.mysql.jdbc.Driver");
        // 2、链接数据库
        String url = "jdbc:mysql://localhost:3306/tulingDB"; // 链接数据库的URL
        String username = "root";
        String password = "3158218k@";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、获取执行SQL语句的对象
        Statement statement = connection.createStatement();
        // 4、定义要执行的SQL语句
        String sql = "insert into pserson(name, age, sex) values ('周杰伦', 45, '男')";

        // 执行完会返回受影响的行数
        int row = statement.executeUpdate(sql);

        // 处理结果
        if (row > 0){
            System.out.println("执行成功");
        }else {
            System.out.println("执行失败");
        }
        sql = "update pserson set age=100 where id =1 ";
        row = statement.executeUpdate(sql);
        if (row > 0){
            System.out.println("执行成功");
        }else {
            System.out.println("执行失败");
        }

        // 释放资源
        statement.close();
        connection.close();


    }
}
