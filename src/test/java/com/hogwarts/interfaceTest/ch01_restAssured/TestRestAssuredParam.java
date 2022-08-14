package com.hogwarts.interfaceTest.ch01_restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestAssuredParam {

    @Test
    public void restAssuredGetParam(){
        given()
                .param("username", "Hogwarts")
                .param("id", 666)
                .log().all()
                .when()
//                .get("https://httpbin.ceshiren.com/get?username=Hogwarts")
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void restAssuredPostParam(){
        given()
                .log().all()
                .when()
                .post("https://httpbin.ceshiren.com/post?username=Hogwarts")
                .then()
                .log().all()
                .statusCode(200);
    }
}
