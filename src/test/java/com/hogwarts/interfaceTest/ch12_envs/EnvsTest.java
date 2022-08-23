package com.hogwarts.interfaceTest.ch12_envs;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class EnvsTest {

    @Test
    public void httpEnvsTest(){
        given()
                .when()
                .get("http://httpbin.org/get")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void httpsEnvsTest(){
        given()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all().statusCode(200);

    }
}
