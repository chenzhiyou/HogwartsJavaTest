package com.hogwarts.interfaceTest.ch09_litemall.api;

import com.hogwarts.interfaceTest.ch09_litemall.model.CartModel;

import static io.restassured.RestAssured.given;

public class CartApi extends BaseLitemallApi{

    public void createProduct(CartModel cartModel){
        String addUrl = "/wx/cart/add";
        String addCartData = "{\"goodsId\":"+cartModel.getGoodsId()+ ",\"number\":1,\"productId\":"+cartModel.getProductId()+"}";
        System.out.println(addCartData);
        given()
                .filter(apiFilter)
//                .header("X-Litemall-Token", userToken)
                .body(addCartData)
                .when()
                .post(addUrl)
                .then()
                .log().all();

    }

    public void deleteProduct(){

    }

    public void getProduct(){

    }

    public void updateProduct(){

    }
}
