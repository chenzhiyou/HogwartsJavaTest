package com.hogwarts.interfaceTest.ch02_restAssured_json;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RestAssuredJsonTest {

    @Test
    public void restAssuredJsonTest(){

        String jsonStr = "{\"hello\": \"hogwarts\"}";

        HashMap<String, String> jsonObj = new HashMap<>();
        jsonObj.put("id", "666");
        given()
                .contentType("application/json")
//                .body(jsonStr)
                .body(jsonObj)
                .when()
                .post("https://httpbin.ceshiren.com/post")
                .then()
                .log()
                .all();
    }
}
