package com.hogwarts.interfaceTest.ch05_restAssured_headers_cookies;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class restAssuredHeaderTest {

    @Test
    public void headerTest(){
        // 配置本地代理
        RestAssured.proxy = host("localhost").withPort(8888);
        // 忽略HTTPS校验
        RestAssured.useRelaxedHTTPSValidation();
        given()
                .header("User-Agent", "Hogwarts", "Host", "ceshiren")
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
