package com.hogwarts.interfaceTest.ch05_restAssured_headers_cookies;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class RestAssuredCookieTest {

    @Test
    public void testCookie(){
        RestAssured.proxy = host("localhost").withPort(8888);
        RestAssured.useRelaxedHTTPSValidation();
        given()
//                .header("Cookie", "my_cookie=hogwarts")
                .cookie("my_cookie_hogwarts", "hogwarts")
                .log().headers()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all()
                .statusCode(200);
    }
}
