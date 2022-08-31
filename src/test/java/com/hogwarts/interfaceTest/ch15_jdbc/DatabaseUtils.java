package com.hogwarts.interfaceTest.ch15_jdbc;

import net.minidev.json.JSONObject;
import org.jooq.Record;
import org.jooq.RecordMapper;
import org.jooq.impl.DSL;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseUtils {
    public Connection connection;
    public Statement statement;

    public DatabaseUtils(String url, String user, String password){
        try {
            connection = DriverManager.getConnection(url, user, password);
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 输入SQL语句，获取查询结果的方法

    // 问题：数据库的数据类型 可能有多种，那么只封装一种，无法适配所有的类型
    // 解决方案：
    // 1、把所有的情况罗列出来，封装成方法
    // 2、直接把ResultSet 转换成String，通过JSONPath，想获取那个就获取那个，不需要考虑返回类型的问题
    public Integer queryIntBySQL(String sql, String columnLabel){
        Integer res = null;
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.first();
            res = resultSet.getInt(columnLabel);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public String getJsonBySQL(String sql){
        // 格式化转换ResultSet，转换为标准的JSON格式，方便断言
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            // 获取所有的原数据
            ResultSetMetaData md = resultSet.getMetaData();
            // 获取所有的数据表列名
            int numCols = md.getColumnCount();
            List<String> colNames = new ArrayList<>();
            for (int i = 1; i<=numCols; i++){
                // 通过索引获取列名
                String name = md.getColumnName(i);
                // 添加到数据表列名到集合中
                colNames.add(name);
            }
            // 返回一个JSON结构的查询结果
            return DSL.using(connection)
                    .fetch(resultSet)
                    .map(new RecordMapper() {
                        public JSONObject map(Record r){
                            JSONObject obj = new JSONObject();
                            colNames.forEach(cn -> obj.put(cn, r.get(cn)));
                            return obj;
                        }
                    }).toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "{}";
    }
}
