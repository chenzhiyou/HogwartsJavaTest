package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.util.FakerUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddMemberTest extends BaseTest{

    @Test
    public void addMemberTest(){
        DocumentContext context = null;
        try {
            context = JsonPath.parse(new File("src/test/resources/member.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        context.set("$.name", FakerUtil.get_name()+FakerUtil.get_zh_phone());
        context.set("$.userid",FakerUtil.get_zh_phone());
        context.set("$.alias", FakerUtil.get_zh_phone());
        context.set("$.mobile", FakerUtil.get_zh_phone());
        String jsonString = context.jsonString();
        System.out.println("==============="+jsonString);
        String addMemberUrl = "https://qyapi.weixin.qq.com/cgi-bin/user/create";
        Response addMemberResponse = given()
                .contentType("application/json")
                .queryParam("access_token", BaseTest.access_token)
                .body(jsonString)
                .log().all()
                .when()
                .post(addMemberUrl)
                .then()
                .log().all()
                .extract().response();
        Integer errcode = addMemberResponse.path("errcode");
        String errmsg = addMemberResponse.path("errmsg");
        assertAll(
                () -> assertEquals(0, errcode),
                () -> assertEquals("created", errmsg)
        );

    }
}
