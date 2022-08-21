package com.hogwarts.interfaceTest.ch09_litemall;

import com.jayway.jsonpath.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class LiteMallTest {

    public static String token;
    public static Integer goodsId;
    public static Integer productId;
    public static String userToken;

    @BeforeAll
    public static void setUpClass(){
        String loginUrl = "https://litemall.hogwarts.ceshiren.com/admin/auth/login";
        String loginData = "{\"username\":\"admin123\",\"password\":\"admin123\",\"code\":\"\"}";

        String loginResponse = given().body(loginData)
                .contentType("application/json")
                .when()
                .post(loginUrl)
                .then()
                .log().all().extract().response().asString();
//        System.out.println(loginResponse);
        token = JsonPath.read(loginResponse, "$.data.token");

        String userLoginUrl = "https://litemall.hogwarts.ceshiren.com/wx/auth/login";
        String userLoginData = "{\"username\":\"user123\",\"password\":\"user123\",\"code\":\"\"}";

        String userLoginResponse = given().body(userLoginData)
                .contentType("application/json")
                .when()
                .post(userLoginUrl)
                .then()
                .log().all().extract().response().asString();
//        System.out.println(loginResponse);
        userToken = JsonPath.read(userLoginResponse, "$.data.token");
        System.out.println("userToken***************"+ userToken);
//        System.out.println(token);
        // 或者提取token的方式：
//        String token1 = given().body(loginData)
//                .contentType("application/json")
//                .when()
//                .post(loginUrl)
//                .then()
//                .log().all().extract().path("data.token");
//        System.out.println(token1);
    }

    @Test
    @Order(1)
    public void addCartTest(){
        // 接口返回请登录
        // 解决：了解登录对应的鉴权方式
        // 在用例开始之前先获取token
        String addProductURL = "https://litemall.hogwarts.ceshiren.com/admin/goods/create";
        String productData = "{\"goods\":{\"picUrl\":\"\",\"gallery\":[],\"isHot\":false,\"isNew\":true,\"isOnSale\":true,\"goodsSn\":\"111111\",\"name\":\"面皮\"},\"specifications\":[{\"specification\":\"规格\",\"value\":\"标准\",\"picUrl\":\"\"}],\"products\":[{\"id\":0,\"specifications\":[\"标准\"],\"price\":0,\"number\":0,\"url\":\"\"}],\"attributes\":[]}";

        given()
                .body(productData)
                .contentType("application/json")
                .header("X-Litemall-Admin-Token", token)
                .when()
                .post(addProductURL)
                .then()
                .log()
                .all();
    }

    @Test
    @Order(2)
    public void goodListTest(){
        String listUrl = "https://litemall.hogwarts.ceshiren.com/admin/goods/list";

        goodsId = given()
                .contentType("application/json")
                .header("X-Litemall-Admin-Token", token)
                .param("name", "开心药丸01")
                .when()
                .get(listUrl)
                .then()
                .log().all()
                .extract().path("data.list[0].id");
        System.out.println(goodsId);

    }

    @Test
    @Order(3)
    public void goodDetailTest(){
        String goodDetailUrl = "https://litemall.hogwarts.ceshiren.com/admin/goods/detail";
        Integer productId = given()
                .contentType("application/json")
                .header("X-Litemall-Admin-Token", token)
                .param("id", goodsId)
                .when()
                .get(goodDetailUrl)
                .then()
                .log().all().extract().path("data.specifications[0].id");
        System.out.println(productId);
    }

    @Test
    @Order(4)
    public void addGoodsTest(){
        // 添加购物车接口
        String addUrl = "https://litemall.hogwarts.ceshiren.com/wx/cart/add";
        String addCartData = "{\"goodsId\":"+goodsId+ ",\"number\":1,\"productId\":"+productId+"}";
        System.out.println(addCartData);
        given()
                .contentType("application/json")
                .header("X-Litemall-Token", userToken)
                .body(addCartData)
                .when()
                .post(addUrl)
                .then()
                .log().all();
    }
}
