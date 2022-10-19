package com.jdbcPro;

import java.sql.*;
import java.util.Scanner;

public class LoginJDBCDemo2 {
    public static void main(String[] args) throws SQLException {
        // 用户在控制台录入用户名和密码，去数据库查询是否存在记录，如果存在，登录成功，否则，登录失败
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pw = scanner.nextLine();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
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
            // SQL语句不再用字符串拼接的方式，用？占位符
            String sql = "select * from users where username=?";
            preparedStatement = connection.prepareStatement(sql);
            // 替换占位符
            preparedStatement.setString(1, name);
            // 执行SQL并获取结果集
            resultSet = preparedStatement.executeQuery();
            // 处理结果
            while (resultSet.next()){
                // 一列一列获取
                String usPw = resultSet.getString("password");
                System.out.println(usPw);
                if (usPw.equals(pw)){
                    System.out.println("登录成功");
                }else {
                    System.out.println("登录失败");
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }finally {
            resultSet.close();
            preparedStatement.close();
            connection.close();
        }
    }

}
