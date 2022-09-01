package com.hogwarts.interfaceTest.ch09_litemall;

import com.hogwarts.interfaceTest.ch09_litemall.filter.FilterDemo;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;


// filter的使用
public class FilterDemoTest {

    @Test
    public void filterDemoTest(){
        FilterDemo filterDemo = new FilterDemo();
        // 没有加filter的时候
        given()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all();

        // 添加filter的使用
        given()
                .filter(filterDemo)
                .when()
                .get("/get")
                .then()
                .log().all();
    }
}
