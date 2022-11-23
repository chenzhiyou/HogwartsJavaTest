package com.myfruits.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBUtils {
    private static Properties properties  = new Properties();
    static {
        try {
            InputStream is = DBUtils.class.getResourceAsStream("/db.properties");
            properties.load(is);
            try {
                Class.forName(properties.getProperty("driver"));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    public static void closeAll(Connection connection , Statement statement, ResultSet resultSet) throws SQLException {
        if (resultSet !=null){
            resultSet.close();
        }
        if (statement != null){
            statement.close();
        }
        if (connection != null){
            connection.close();
        }
    }
}
