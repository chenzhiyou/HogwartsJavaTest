package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.util.MapperUtil;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

// 优化一：配置文件获取token，不同的企业直接去修改配置文件即可，不需要改动代码解耦
public class TokenProTest {
    // 1、config.properties
    // 2、config.yaml
    public static String access_token;
    String corpid = "corpid";
    String corpsecret="corpsecret";

    @Test
    public void getTokenFromProperty(){
        String corpidValue = new ConfigUtil().getProperties(corpid).toString();
        String corpsecretValue = new ConfigUtil().getProperties(corpsecret).toString();

        String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
        access_token = given()
                .contentType("application/json")
                .param("corpid", corpidValue)
                .param("corpsecret", corpsecretValue)
                .log().all()
                .when()
                .get(getTokenUrl)
                .then()
                .log()
                .all().extract().path("access_token");
        System.out.println(access_token);
    }

    // 使用配置文件获取token
    @Test
    public void getTokenFromYaml(){
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
        access_token =requestSpecification
                .contentType("application/json")
                .when()
                .get(getTokenUrl)
                .then()
                .log()
                .all().extract().path("access_token");
        System.out.println(access_token);



    }

}
