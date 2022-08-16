package com.hogwarts.interfaceTest.ch08_restAssured_multipart;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class RestAssuredMultipartTest {

    @Test
    public void multipartTest(){

        File myFile = new File("src/test/resources/hogwarts.txt");

        RestAssured.proxy = host("localhost").withPort(8888);
        RestAssured.useRelaxedHTTPSValidation();

        given()
                .multiPart("hogwarts", myFile)
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
