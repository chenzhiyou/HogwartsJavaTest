package learn.ch33_jdbc;

import java.sql.*;

public class JDBCDemo {
    static final String DB_URL="jdbc:mysql://litemall.hogwarts.ceshiren.com:13306/litemall?useSSL=false";
    static final String USER = "test";
    static final String PASS = "test123456";
    static final String QUERY ="select * from litemall_cart where user_id=1 and deleted=1";
    static final String QUERYPRE ="select * from litemall_cart where user_id=? and deleted=1";


    public static void main(String[] args) {
        try {
            // 建立连接
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);

            System.out.println(resultSet);
            // 获取第一行的数据
            resultSet.first();
            // 在调用获取某一列的数据
            System.out.println(resultSet.getInt("id"));
            PreparedStatement preparedStatement = connection.prepareStatement(QUERYPRE, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            preparedStatement.setInt(1, 1);
            ResultSet resultSet1 = preparedStatement.executeQuery();

            // 获取第一行的数据
            resultSet1.first();
            // 在调用获取某一列的数据
            System.out.println(resultSet1.getInt("id"));
            // 关闭连接
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
