package com.hogwarts.interfaceTest.ch06_restAssured_from;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class RestAssuredFromTest {

    @Test
    public void fromTest(){
        RestAssured.proxy = host("localhost").withPort(8888);
        RestAssured.useRelaxedHTTPSValidation();
        given()
//                .formParam("myParam", "hogwarts")
                .formParams("username", "hhh", "pwd", 123456)
                .log().headers()
                .log().body()
                .when()
                .post("https://httpbin.ceshiren.com/post")
                .then()
                .log()
                .all()
                .statusCode(200);
    }
}
