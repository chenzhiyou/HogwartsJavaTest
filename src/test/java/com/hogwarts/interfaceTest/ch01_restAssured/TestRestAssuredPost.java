package com.hogwarts.interfaceTest.ch01_restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestAssuredPost {

    @Test
    public void restAssuredPostTest(){
        given()
                .when()
                .post("https://httpbin.ceshiren.com/post")
                .then()
                .log().all()
                .statusCode(200);
    }
}
