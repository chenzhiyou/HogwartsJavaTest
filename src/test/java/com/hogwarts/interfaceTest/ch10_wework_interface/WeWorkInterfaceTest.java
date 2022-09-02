package com.hogwarts.interfaceTest.ch10_wework_interface;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class WeWorkInterfaceTest {
    public static String access_token;

    @BeforeAll
    public static void getTokenTest(){
        // 获取 access_token
        String getTokenUrl = " https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=ww788b297224442e00&corpsecret=3nAWJNugY6nIyRpmhbjmV1-YjW_Ro-l2bmZWgCun9oY";
        access_token = given()
                .contentType("application/json")
                .log().all()
                .when()
                .get(getTokenUrl)
                .then()
                .log()
                .all().extract().path("access_token");
    }


}
