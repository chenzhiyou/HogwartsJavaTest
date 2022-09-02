package com.hogwarts.interfaceTest.ch09_litemall;

import com.hogwarts.interfaceTest.ch09_litemall.api.CartApi;
import com.hogwarts.interfaceTest.ch09_litemall.api.GoodApi;
import com.hogwarts.interfaceTest.ch09_litemall.model.CartModel;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CartApiTest {

    public static GoodApi goodApi;
    public static CartApi cartApi;
    public static String token;
    public static String userToken;

    @BeforeAll
    public  static void setUpClass(){
        goodApi = new GoodApi();
        cartApi = new CartApi();

//        String loginUrl = "https://litemall.hogwarts.ceshiren.com/admin/auth/login";
//        String loginData = "{\"username\":\"admin123\",\"password\":\"admin123\",\"code\":\"\"}";
//
//        String loginResponse = given().body(loginData)
//                .contentType("application/json")
//                .when()
//                .post(loginUrl)
//                .then()
//                .log().all().extract().response().asString();
////        System.out.println(loginResponse);
//        token = JsonPath.read(loginResponse, "$.data.token");

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
    }

    /**
     * 问题：输入以及输出
     * 问题：token依然暴露在测试用例中，但token和cart没有任何的业务逻辑关系，应该隐藏起来
     */

    @Test
    public void createProductTest(){
        // 上架商品
        CartModel cartModel = new CartModel();
        String goodsData = "{\"goods\":{\"picUrl\":\"\",\"gallery\":[],\"isHot\":false,\"isNew\":true,\"isOnSale\":true,\"goodsSn\":\"111111\",\"name\":\"面皮\"},\"specifications\":[{\"specification\":\"规格\",\"value\":\"标准\",\"picUrl\":\"\"}],\"products\":[{\"id\":0,\"specifications\":[\"标准\"],\"price\":0,\"number\":0,\"url\":\"\"}],\"attributes\":[]}";
//        goodApi.createGood(token, goodsData);
        // 调用查询商品列表接口，获取商品ID
        Integer goodsID =goodApi.getGood();
        // 查询商品详情接口，获取商品库存ID
        goodApi.detailGood(goodsID);
        // 调用添加购物车接口
        cartApi.createProduct();

    }
}
