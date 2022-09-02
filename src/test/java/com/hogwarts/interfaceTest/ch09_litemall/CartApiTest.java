package com.hogwarts.interfaceTest.ch09_litemall;

import com.hogwarts.interfaceTest.ch09_litemall.api.CartApi;
import com.hogwarts.interfaceTest.ch09_litemall.api.GoodApi;
import com.hogwarts.interfaceTest.ch09_litemall.model.CartModel;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.given;

public class CartApiTest {

    public static GoodApi goodApi;
    public static CartApi cartApi;
    public static String token;
    public static String userToken;

    @BeforeAll
    public  static void setUpClass(){
        goodApi = new GoodApi();
        //初始化token
        goodApi.setRole("admin");
        goodApi.initToken("admin123", "admin123");
        // set filter
        goodApi.addFilter();
        cartApi = new CartApi();
        cartApi.setRole("client");
        cartApi.initToken("user123", "user123");
        cartApi.addFilter();
    }

    /**
     * 问题：输入以及输出
     * 问题：token依然暴露在测试用例中，但token和cart没有任何的业务逻辑关系，应该隐藏起来
     */

    @ParameterizedTest
    @CsvSource("1057036, 面皮1" )
    public void createProductTest(String goodsSn, String goosName){
        // 上架商品
        CartModel cartModel = new CartModel();
        cartModel.setNumber(1);
//        String goodsData = "{\"goods\":{\"picUrl\":\"\",\"gallery\":[],\"isHot\":false,\"isNew\":true,\"isOnSale\":true,\"goodsSn\":\"111111\",\"name\":\"面皮\"},\"specifications\":[{\"specification\":\"规格\",\"value\":\"标准\",\"picUrl\":\"\"}],\"products\":[{\"id\":0,\"specifications\":[\"标准\"],\"price\":0,\"number\":0,\"url\":\"\"}],\"attributes\":[]}";
//        goodApi.createGood(token, goodsData);
        // 调用查询商品列表接口，获取商品ID
        Integer goodsID =goodApi.getGood();
        cartModel.setGoodsId(goodsID);

        // 查询商品详情接口，获取商品库存ID
        Integer productId = goodApi.detailGood(goodsID);
        cartModel.setProductId(productId);
        // 调用添加购物车接口
        cartApi.createProduct(cartModel);

    }
}
