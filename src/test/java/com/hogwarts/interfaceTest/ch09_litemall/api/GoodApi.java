package com.hogwarts.interfaceTest.ch09_litemall.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hogwarts.interfaceTest.ch09_litemall.model.CartModel;
import io.restassured.filter.Filter;

import static io.restassured.RestAssured.given;

/**
 * 货品相关
 */
public class GoodApi {

    Filter apiFilter = new ApiFilter();

    // 问题:given
    // 问题：如果传入的数据必须是JSON，将Object转换为JSON
    // 解决方案：使用JSON直接转换即可
//        System.out.println(cartModel);
//        System.out.println(cartModel.getGoodsId());
//    // 可以直接使用对象，不需要进行数据类型转换
//    given().body(cartModel);

    // 对象转换成String
//    ObjectMapper objectMapper = new ObjectMapper();
//        try {
//        String cartString = objectMapper.writeValueAsString(cartModel);
//        System.out.println(cartString);
//    } catch (JsonProcessingException e) {
//        e.printStackTrace();
//    }
    public void  createGood(String goodsData){


        String addProductURL = "/admin/goods/create";

        given()
                .filter(apiFilter)
                .body(goodsData)
                .contentType("application/json")
//                .header("X-Litemall-Admin-Token", token)
                .when()
                .post(addProductURL)
                .then()
                .log()
                .all();

    }

    public void deleteGood(){

    }

    public Integer getGood(){
        String listUrl = "/admin/goods/list";

        Integer goodsId = given()
                .filter(apiFilter)
                .contentType("application/json")
//                .header("X-Litemall-Admin-Token", token)
                .param("name", "开心药丸01")
                .when()
                .get(listUrl)
                .then()
                .log().all()
                .extract().path("data.list[0].id");
        System.out.println(goodsId);
        return goodsId;
    }

    public void updateGood(){

    }

    public void detailGood(Integer goodsId){
        String goodDetailUrl = "/admin/goods/detail";
        Integer productId = given()
                .filter(apiFilter)
                .contentType("application/json")
//                .header("X-Litemall-Admin-Token", token)
                .param("id", goodsId)
                .when()
                .get(goodDetailUrl)
                .then()
                .log().all().extract().path("data.specifications[0].id");
        System.out.println(productId);
    }
}
