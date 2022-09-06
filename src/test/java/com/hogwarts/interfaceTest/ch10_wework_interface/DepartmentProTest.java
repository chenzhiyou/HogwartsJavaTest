package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.util.FakerUtil;
import io.restassured.response.Response;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

public class DepartmentProTest extends BaseTest{

    public static Integer departmentId;
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
        departmentId = response.path("id");

        // 多断言
        assertAll(
                () -> assertEquals(0, errCode),
                () -> assertEquals("created", errMsg)
        );
    }

    @Test
    public void addDepartTest(){
        DocumentContext context = null;
        try {
            context = JsonPath.parse(new File("src/test/resources/department3.json"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        context.set("$.name", FakerUtil.get_name()+FakerUtil.get_zh_phone());
        context.set("$.order", FakerUtil.getNum(30));
        String jsonString = context.jsonString();
        System.out.println(jsonString);
        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;

        Response response = given()
                .contentType("application/json")
                .body(jsonString)
                .when()
                .post(creatDepartmentUrl)
                .then()
                .log().all().extract().response();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");
        departmentId = response.path("id");

        // 多断言
        assertAll(
                () -> assertEquals(0, errCode),
                () -> assertEquals("created", errMsg)
        );

    }

    // 使用JsonSchema进行模板断言
    @Test
    @Disabled
    public void getDepartment(){
        System.out.println(departmentId);
        String departmentListUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/simplelist";
        Response response = given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
//                .queryParam("id", 2)
                .when()
                .get(departmentListUrl)
                .then()
                .log().all()
//                .body(matchesJsonSchemaInClasspath("department.json")) // 模板断言
                .extract().response();
        Integer errcode = response.path("errcode");
        String errmsg = response.path("errmsg");

        assertAll(
                () -> assertEquals(0, errcode),
                () -> assertEquals("ok", errmsg)
        );

    }

    @Test
    @Disabled
    public void deleteDepartment(){
        // 获取部分
        String departmentListUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/simplelist";
        Response response = given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
                .when()
                .get(departmentListUrl)
                .then()
                .log().all()
//                .body(matchesJsonSchemaInClasspath("department.json")) // 模板断言
                .extract().response();
        // 获取order<100的部门ID列表
        List<Integer> orderId = response.path("department_id.findAll{ it.order <1000}.id");
        System.out.println(orderId);
        String deleteUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";
        orderId.forEach(
                id ->{
                    Response deleteResponse = given()
                            .contentType("application/json")
                            .queryParam("access_token", access_token)
                            .queryParam("id", id)
                            .when()
                            .get(deleteUrl)
                            .then()
                            .log().all().extract().response();
                    Integer errcode = deleteResponse.path("errcode");
                    String errmsg = deleteResponse.path("errmsg");
                    assertAll(
                            () -> assertEquals(0, errcode),
                            () -> assertEquals("deleted", errmsg)
                    );
                    System.out.println(id);
                }

        );
    }

    @ParameterizedTest
    @MethodSource
    public void deleteParamsDepartment(int departmentId){
        String deleteUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";
        Response deleteResponse = given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
                .queryParam("id", departmentId)
                .when()
                .get(deleteUrl)
                .then()
                .log().all().extract().response();
        Integer errcode = deleteResponse.path("errcode");
        String errmsg = deleteResponse.path("errmsg");
        if (departmentId < 0){
            assertAll(
                    () -> assertEquals(40058, errcode),
                    () -> assertThat(errmsg,is(containsString("field `id` expect type `uint32`")))
            );
        }else{
            assertAll(
                    () -> assertEquals(0, errcode),
                    () -> assertEquals("deleted", errmsg)
            );
        }

    }

    static Stream<Arguments> deleteParamsDepartment(){
        String departmentListUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/simplelist";
        Response response = given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
                .when()
                .get(departmentListUrl)
                .then()
                .log().all()
//                .body(matchesJsonSchemaInClasspath("department.json")) // 模板断言
                .extract().response();
        // 获取order<100的部门ID列表
        List<Arguments> orderId = response.path("department_id.findAll{ it.order <1000}.id");
        System.out.println(orderId);
        if (orderId.isEmpty()){
            return Stream.of(Arguments.arguments(-1));
        }else {
            return orderId.stream();
        }
    }
}
