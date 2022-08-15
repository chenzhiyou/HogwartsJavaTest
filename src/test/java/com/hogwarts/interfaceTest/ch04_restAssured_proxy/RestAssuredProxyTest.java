package com.hogwarts.interfaceTest.ch04_restAssured_proxy;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class RestAssuredProxyTest {

    @Test
    public void httpProxyTest(){
        RestAssured.proxy = host("localhost").withPort(8888);

        given()
//                .proxy(8888)
                .relaxedHTTPSValidation()// 忽略HTTPS校验
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all();
    }
}
