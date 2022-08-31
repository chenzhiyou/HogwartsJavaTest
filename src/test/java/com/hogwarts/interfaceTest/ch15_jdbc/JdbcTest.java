package com.hogwarts.interfaceTest.ch15_jdbc;

import org.junit.jupiter.api.Test;

import java.sql.*;

/**
 * 数据库语句使用
 * Statement 将其用于对数据库的通用访问，Statement接口不能接受参数
 *      ResultSet executeQuery (String SQL) 返回一个ResultSet对象，当您希望获得结果集时使用此方法，就像SELECT语句一样
 *      boolean execute (String SQL) 如果可以检索到ResultSet对象，则返回布尔值true，否则，它返回false。使用此方法执行SQL DDL语句或需要使用真正动态的SQL；
 *      int executeUpdate (String SQL) 返回受SQL执行影响的行数，使用此方法来执行您希望影响的行数的SQL，例如：INSET、update或delete语句
 * PreparedStatement 在运行时接受输入参数
 *      提供的方法与Statement一致
 *      可以实现动态提供参数
 *          ?作为参数
 *          setXXX()方法将值绑定到参数
 *          调用executeQuery()不需要传参
 * CallableStatement 访问数据库存储过程时使用，接受运行时数据参数
 * 结果集：
 *      ResultSet是查询结果的集合
 *      先声明获取哪一行的数据：
 *          rs.last();
 *          rs.first();
 *          rs.next();
 *      再声明获取哪一列的数据：
 *          rs.getInt("列名")
 *          rs.getInt(列的索引)
 */
public class JdbcTest {
    // 连接数据库 jdbc: 驱动://主机:端口/数据库名
    public static final String DB_URL = "jdbc:mysql://litemall.hogwarts.ceshiren.com:13306/litemall?useSSL=false";
    public static final String USER = "test";
    public static final String PASSWORD = "test123456";
    public static final String QUERY = "select * from litemall_cart where user_id=1 and deleted=0";
    public static final String QUERYPRE = "select * from litemall_cart where user_id=? and deleted=?";

    @Test
    public void jdbcStatementTest() throws SQLException {
        // 建立连接
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // 执行SQL语句
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        ResultSet resultSet = statement.executeQuery(QUERY);
        resultSet.first();
        // 在调用获取某一列的数据
        System.out.println(resultSet.getInt("id"));
        System.out.println(resultSet);
        // 遍历所以的查询结果
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id"));
        }
        // 关闭连接
        connection.close();
    }

    @Test
    public void jdbcPreparedStatementTest() throws SQLException {
        // 建立连接
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        // 执行SQL语句
        PreparedStatement preparedStatement = connection.prepareStatement(QUERYPRE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        // 问题： No value specified for parameter 1
        // 解决：第一个参数代表参数的位置，第二个参数代表赋值
        preparedStatement.setInt(1, 1);
        preparedStatement.setInt(2, 0);
        ResultSet resultSet = preparedStatement.executeQuery();
        // 获取第一行的数据
        resultSet.first();
        // 在调用获取某一列的数据
        System.out.println(resultSet.getInt("id"));
        System.out.println(resultSet);
        // 关闭连接
        connection.close();
    }
}
