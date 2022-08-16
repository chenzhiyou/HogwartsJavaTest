package com.hogwarts.interfaceTest.ch07_restAssured_timeout;

import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class RestAssuredTimeoutTest {



    @BeforeAll
    public static void setUpClass(){
        RestAssured.baseURI = "https://httpbin.ceshiren.com";
    }

    @Test
    public void case1Test(){
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200);
    }

    @Test
    public void case2Test(){

        /**
         * 创建HttpClientConfig实例
         * 创建RestAssuredConfig实例
         * given语句中调用config()方法
         */

        HttpClientConfig httpClientConfig = HttpClientConfig
                .httpClientConfig()
                .setParam("http.socket.timeout", 3000);

        RestAssuredConfig restAssuredConfig = RestAssuredConfig.config().httpClient(httpClientConfig);

        given()
                .config(restAssuredConfig)
                .when()
                .get("/delay/10")
                .then()
                .statusCode(200);
    }

    @Test
    public void case3Test(){
        given()
                .when()
                .get("/get")
                .then()
                .statusCode(200);
    }
}
