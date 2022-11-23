package com.myfruits.util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.util.DruidWebUtils;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
    // 声明一个数据库连接池对象
    private static DruidDataSource dataSource;
    static {
        Properties properties = new Properties();
        InputStream resourceAsStream = DruidWebUtils.class.getResourceAsStream("/druid.properties");
        try {
            properties.load(resourceAsStream);
            // 初始化数据源
            dataSource = (DruidDataSource)DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // 获取数据库连接
    public static Connection getConnection(){
        try {
            Connection connection = dataSource.getConnection();
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    // 关闭数据库
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
