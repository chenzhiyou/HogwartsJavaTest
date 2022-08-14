package com.hogwarts.interfaceTest.ch02_restAssured_json;

import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestAssuredJsonPathTest {

    @Test
    public void restAssuredJsonResponseTest(){
        String resp = given()
                .header("hello", "hogwarts")
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all().extract().response().asString();
        String word = from(resp).getString("headers.Hello");
        System.out.println(word);
        assertEquals("hogwarts", word);
    }

    /**
     * 另外一种对JSON数据的解析
     */
    @Test
    public void restAssuredJsonPathTest(){
        String resp = given()
                .header("hello", "hogwarts")
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all().extract().response().asString();
        String path = JsonPath.read(resp, "$.headers.Hello");
        System.out.println(path);
        assertEquals("hogwarts", path);
    }
}
