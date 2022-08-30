package com.hogwarts.interfaceTest.ch14_verifiy;

import io.restassured.filter.cookie.CookieFilter;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CookieTest {


    /**
     * 如何直接添加cookie认证信息
     * 场景：已经有对应的cookie鉴权的信息，只需要在请求过程中添加到cookie即可
     */
    @Test
    public void addCookieTest(){
        given()
                .cookie("user", "ad")
                .when()
                .get("https://httpbin.ceshiren.com/cookies")
                .then()
                .log().all();
    }
    // 问题：通常cookie是不能像用户名密码一样有直接的数据的
    // 解决方法：模拟正常的set-cookie的过程
    @Test
    public void addCookieByFilter(){
        CookieFilter cookieFilter = new CookieFilter();
        given()
                .redirects().follow(false) // 禁止重定向
                .filter(cookieFilter)
                .when()
                .get("https://httpbin.ceshiren.com/cookies/set/user/ad")
                .then()
                .log().all();
        // 问题：如何在收到 Set-Cookie后，将对应的cookie信息提取出来，并添加在下一次的cookie中
        // 解决办法：使用cookieFilter
        // 第二次请求： 添加cookie
        given()
                .filter(cookieFilter)
                .when()
                .get("https://httpbin.ceshiren.com/cookies")
                .then()
                .log().all();

        given()
                .filter(cookieFilter).cookie("counts", "2")
                .when()
                .get("https://httpbin.ceshiren.com/cookies/set/user/ad")
                .then()
                .log().all();
    }

    // 获取token
    @Test
    public void addToken(){
        String bodyData = "{\"username\":\"admin123\", \"password\":\"admin123\", \"code\":\"\"}";
        String token = given()
                .body(bodyData).contentType("application/json")
                .when()
                .post("https://litemall.hogwarts.ceshiren.com/admin/auth/login")
                .then()
                .log().all().extract().path("data.token");
        System.out.println(token);

        // token的添加，解决接口鉴权问题
        given()
                .header("X-Litemall-Admin-Token", token)
                .when()
                .get("https://litemall.hogwarts.ceshiren.com/admin/goods/list")
                .then().log().all();
    }

    @Test
    public void addAuthTest(){
        given()
                .auth().basic("user", "ad")
                .when()
                .get("https://httpbin.ceshiren.com/basic-auth/user/ad")
                .then().log().all();
    }
}
