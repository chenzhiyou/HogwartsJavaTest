package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.FakerUtil;
import com.util.MapperUtil;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 参数传递模板化：
 *      问题：
 *          硬编码
 *          参数传递模板后需要特定解析代码才能获取值
 *      解决思路：
 *          不编写解析规则，直接使用第三方依赖解决替换
 *      解决方案：
 *          JSONPath：只能解析Json参数
 *          Mustache：
 */
public class WeWorkInterfaceTest {
    public static String access_token;

    @BeforeAll
    public static void getToken(){
        // 获取 access_token ?corpid=ww788b297224442e00&corpsecret=3nAWJNugY6nIyRpmhbjmV1-YjW_Ro-l2bmZWgCun9oY
        String getTokenUrl = "https://qyapi.weixin.qq.com/cgi-bin/gettoken";
        access_token = given()
                .contentType("application/json")
                .param("corpid", "ww788b297224442e00")
                .param("corpsecret", "3nAWJNugY6nIyRpmhbjmV1-YjW_Ro-l2bmZWgCun9oY")
                .log().all()
                .when()
                .get(getTokenUrl)
                .then()
                .log()
                .all().extract().path("access_token");
//        System.out.println(access_token);
    }



    @Test
    public void createDepartmentTest(){
        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;
        String departmentData = "{\n" +
                "   \"name\": \"广州研发中心\",\n" +
                "   \"name_en\": \"RDGZ\",\n" +
                "   \"parentid\": 1,\n" +
                "   \"order\": 1,\n" +
                "   \"id\": 2\n" +
                "}\n" +
                "\n";
        Response response = given()
                .contentType("application/json")
                .body(departmentData)
                .when()
                .post(creatDepartmentUrl)
                .then()
                .log().all().extract().response();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");
        Integer id = response.path("id");

        // 多断言
        assertAll(
                () -> assertEquals(1, errCode),
                () -> assertEquals("created", errMsg),
                () -> assertEquals(2, id)
        );


    }

    @Test
    public void departmentListTest(){
        String departmentListUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/simplelist";
        given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
                .queryParam("id", 2)
                .when()
                .get(departmentListUrl)
                .then()
                .log().all();
    }

    @Test
    public void deleteDepartmentTest(){
        String deleteUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/delete";
        given()
                .contentType("application/json")
                .queryParam("access_token", access_token)
                .queryParam("id", 2)
                .when()
                .get(deleteUrl)
                .then()
                .log().all();
    }

    @Test
    public void createDepartmentByJsonTest(){
        // 解析文件类型声明
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        // 定义要解析的数据类型
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {};

        try {
            List<HashMap<String, Object>> departmentBody = objectMapper.readValue(new File("src/test/resources/department.json"), typeReference);
            System.out.println(departmentBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    @ParameterizedTest
//    @JsonFileSource(resource="src/test/resources/department.json")
//    public void createDepartmentByUtil(){
//        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;
//        Response response = given()
//                .contentType("application/json")
//                .body(departmentData)
//                .when()
//                .post(creatDepartmentUrl)
//                .then()
//                .log().all().extract().response();
//        Integer errCode = response.path("errcode");
//        String errMsg = response.path("errmsg");
//        assertAll(
//                () -> assertEquals(1, errCode),
//                () -> assertEquals("created", errMsg)
//        );
//    }

    @Test
    public void createDepartmentByUtilsTest(){
        HashMap<String, Object> readValue = new MapperUtil<HashMap<String, Object>>().getReadValue("src/test/resources/department2.json");
        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;

        Response response = given()
                .contentType("application/json")
                .body(readValue)
                .when()
                .post(creatDepartmentUrl)
                .then()
                .log().all().extract().response();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");
    }

    @Test
    public void addDepartmentTest(){
        HashMap<String, Object> departBody = new HashMap<>();
        HashMap<String, Object> readValue = new MapperUtil<HashMap<String, Object>>().getReadValue("src/test/resources/department3.json");
        String creatDepartmentUrl = "https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token="+ access_token;

        readValue.forEach(
                (s, o) ->{
                    String value = o.toString();
                    if (value.startsWith("${") && value.endsWith("}")){
                        String s1 = StringUtils.stripStart(value, "${");
                        String s2 = StringUtils.stripEnd(s1, "}");
                        if ("departmentName".equals(s2)){
                            o = FakerUtil.get_name()+FakerUtil.get_zh_phone();
                        }
                        if ("orderId".equals(s2)){
                            o = FakerUtil.getNum(30);
                        }

                    }
                    departBody.put(s, o);
                }
        );
        System.out.println(departBody);

        Response response = given()
                .contentType("application/json")
                .body(departBody)
                .when()
                .post(creatDepartmentUrl)
                .then()
                .log().all().extract().response();
        Integer errCode = response.path("errcode");
        String errMsg = response.path("errmsg");
        assertAll(
                () -> assertEquals(0, errCode),
                () -> assertEquals("created", errMsg)
        );
    }

}
