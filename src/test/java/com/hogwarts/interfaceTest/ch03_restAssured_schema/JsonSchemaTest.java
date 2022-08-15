package com.hogwarts.interfaceTest.ch03_restAssured_schema;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaTest {

    @Test
    public void jsonSchemaTest(){
        given()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log()
                .all()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schema.json"));
    }
}
