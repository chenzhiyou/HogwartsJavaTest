package com.hogwarts.interfaceTest.ch01_restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestAssuredGet {

    @Test
    void restAssuredGetTest(){
        given()
                .log().all() // 打印请求信息
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all()// 打印完整的响应信息
                .statusCode(200); // 响应状态码断言
    }
}
