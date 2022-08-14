package com.hogwarts.interfaceTest.ch01_restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestRestAssuredAssert {

    @Test
    public void restAssuredAssertTest(){
        given()
                .log().all() // 打印请求信息
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log()
                .all()
                .body("origin",equalTo("172.17.56.110"));
    }
}
