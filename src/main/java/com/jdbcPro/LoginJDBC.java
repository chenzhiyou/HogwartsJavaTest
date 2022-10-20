package com.jdbcPro;

import java.sql.*;
import java.util.Scanner;

public class LoginJDBC {
    public static void main(String[] args) throws SQLException {
        // 用户在控制台录入用户名和密码，去数据库查询是否存在记录，如果存在，登录成功，否则，登录失败
        Scanner scanner = new Scanner(System.in);
        System.out.println("请录入用户名：");
        String name = scanner.nextLine();
        System.out.println("请输入密码：");
        String pw = scanner.nextLine();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            // 注册驱动
//            Class.forName("com.mysql.jdbc.Driver");
            // 连接数据库
            connection = DBUtils.getConnection();
            // 获取执行SQL的对象
            statement = connection.createStatement();
            // 执行SQL并获取结果集
            resultSet = statement.executeQuery("select * from users where username='"+name+"'");
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
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.CloseAll(connection, statement, resultSet);
        }
    }

}
