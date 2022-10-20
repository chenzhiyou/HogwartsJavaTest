package com.jdbcPro;

import java.io.*;
import java.sql.*;
import java.util.Properties;

/**
 * 工具类：Arrays, Collections
 */
public class DBUtils {
    // 只需要加载一次，而且是在所有的方法调用之前加载
    private static Properties properties = null;
    private static FileReader fileReader = null;
    static {
        properties = new Properties();
        // 数据库的配置文件属于源码的一部分，更习惯将配置文件放到src 路径下
        try {
            fileReader = new FileReader("src/main/resources/db.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        InputStream resourceAsStream = DBUtils.class.getClassLoader().getResourceAsStream("src/main/resources/db.properties");
        try {
            properties.load(fileReader);
            Class.forName(properties.getProperty("driverCLass"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接的方法的封装
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        // 获取连接
        String url = properties.getProperty("url"); // 链接数据库的URL
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    /**
     * 关闭资源
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void CloseAll(Connection connection, Statement statement, ResultSet resultSet){
        // 先开后关闭
        try {
            if (resultSet!=null){
                resultSet.close();
            }
            if (statement !=null){
                statement.close();
            }

            if (connection!=null){
                connection.close();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {
        String url = properties.getProperty("url"); // 链接数据库的URL
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        System.out.println(url);
        System.out.println(username);
        System.out.println(password);
    }
}
