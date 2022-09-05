package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.util.FakerUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DepartmentProTest extends BaseTest{

    @Test
    public void adaWithJsonPathTest(){
        // HashMap 存入修改字段
        Integer id = FakerUtil.getNum(30);
        System.out.println(id);
        HashMap<String, Object> hashMap = new HashMap<String, Object>(){{
           put("departmentName", FakerUtil.get_name()+FakerUtil.get_zh_phone());
           put("orderId", id );
        }};
        DefaultMustacheFactory factory = new DefaultMustacheFactory();
        Mustache mustache = factory.compile("department4.mustache");
        ByteArrayOutputStream strem = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(strem);
        mustache.execute(writer, hashMap);
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String departmentInfo =new String(strem.toByteArray());
        System.out.println(departmentInfo);

        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;

        Response response = given()
                .contentType("application/json")
                .body(departmentInfo)
                .when()
                .post(creatDepartmentUrl)
                .then()
                .log().all().extract().response();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");
        Integer departmentId = response.path("id");

        // 多断言
        assertAll(
                () -> assertEquals(0, errCode),
                () -> assertEquals("created", errMsg)
        );
    }
}
