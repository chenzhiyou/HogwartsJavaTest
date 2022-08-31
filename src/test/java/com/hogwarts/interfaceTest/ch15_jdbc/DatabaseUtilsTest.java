package com.hogwarts.interfaceTest.ch15_jdbc;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.w3c.dom.stylesheets.LinkStyle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DatabaseUtilsTest {

    public static final String DB_URL = "jdbc:mysql://litemall.hogwarts.ceshiren.com:13306/litemall?useSSL=false";
    public static final String USER = "test";
    public static final String PASSWORD = "test123456";
    public static final String QUERY = "select * from litemall_cart where user_id=1 and deleted=0";
    public static final String QUERYPRE = "select * from litemall_cart where user_id=? and deleted=?";


    @Test
    public void queryBySQL(){
        DatabaseUtils databaseUtils = new DatabaseUtils(DB_URL, USER, PASSWORD);
        // 问题： Operation not allowed for a result set of type ResultSet.TYPE_FORWARD_ONLY.
        // 解决办法：createStatement的时候添加ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY 配置
        Integer res = databaseUtils.queryIntBySQL(QUERY, "id");
        System.out.println(res);

    }

    @Test
    public void getJsonBySQLTest(){
        DatabaseUtils databaseUtils = new DatabaseUtils(DB_URL, USER, PASSWORD);
        String jsonBySQL = databaseUtils.getJsonBySQL(QUERY);
        List<String> goodsNameList = JsonPath.read(jsonBySQL, "$..goods_name");
        System.out.println(jsonBySQL);
        System.out.println(goodsNameList);
    }
}
