package com.hogwarts.interfaceTest.ch10_wework_interface.po;

import com.util.MapperUtil;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * 封装token
 */
public class GetToken {
    public static String access_token;
    public static String getAccessToken(){
        MapperUtil<HashMap<String, List<HashMap<String, Object>>>> mapMapperUtil = new MapperUtil<>();
        HashMap<String, List<HashMap<String, Object>>> readValue = mapMapperUtil.getReadValue("src/test/resources/config.yaml");
        System.out.println(readValue);
        List<HashMap<String, Object>> master = readValue.get("master");
        System.out.println(master);
        RequestSpecification requestSpecification = given().log().all();

        master.forEach(stringObjectHashMap -> {
            System.out.println(stringObjectHashMap);
            requestSpecification.queryParams(stringObjectHashMap);
        });
        String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
        access_token = requestSpecification
                .contentType("application/json")
                .when()
                .get(getTokenUrl)
                .then()
                .log()
                .all().extract().path("access_token");
        System.out.println(access_token);
        return access_token;
    }
}
