package com.hogwarts.interfaceTest.ch12_envs;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class EnvsTestConfig {

    @Test
    public void envsConfigTest(){
        HashMap<String, String> envs = new HashMap<>();
        envs.put("org", "http://httpbin.org");
        envs.put("httpsEnv", "https://httpbin.ceshiren.com");
        envs.put("default", "httpsEnv");

        RestAssured.baseURI= envs.get(envs.get("default"));

        given()
                .when()
                .get("/get")
                .then()
                .log().all()
                .statusCode(200);
    }
}
