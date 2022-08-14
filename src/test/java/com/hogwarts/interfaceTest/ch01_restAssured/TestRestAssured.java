package com.hogwarts.interfaceTest.ch01_restAssured;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestRestAssured {

    @Test
    void fun(){
        given()
                .header("Hello", "hogwarts")
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log()
                .all();
    }
}
