package com.hogwarts.interfaceTest.ch13_mulitiResTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class XmlToJsonTest {

    @Test
    public void JsonTest() throws IOException {
        String s = given()
                .when()
                .get("https://httpbin.ceshiren.com/get")
                .then()
                .log().all().extract().body().asString();
        mulitiResToJson(s);
        List<String> host = JsonPath.read(s, "$..Host");
        assertEquals("httpbin.ceshiren.com", host.get(0));
    }
    // 将xml转化为JSON方法封装
    public String mulitiResToJson(String originRes) throws IOException {
        String res = null;
        if (originRes.startsWith("<?xml")){
            XmlMapper xmlMapper = new XmlMapper();
            JsonNode node =xmlMapper.readTree(originRes.getBytes());
            ObjectMapper objectMapper =new ObjectMapper();
            res = objectMapper.writeValueAsString(node);
        }else {
            res = originRes;
        }
       
        return res;
    }
    @Test
    public void xmlTest() throws IOException {
        String xmlResBody = given()
                .when()
                .get("https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss")
                .then()
                .log().all().extract().body().asString();
        // 将xml转化为JSON
        String res =mulitiResToJson(xmlResBody);
        List<String> titleList = JsonPath.read(res, "$..title");
        System.out.println(titleList);
    }
}
