package com.hogwarts.interfaceTest.ch11_base64;

import io.restassured.RestAssured;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static io.restassured.specification.ProxySpecification.host;

public class InterfaceBaseTest {

    @Test
    public void base64Test(){
        // 获取一个字节数组,加密
        byte[] arr = "hogwarts".getBytes(StandardCharsets.UTF_8);
        String baseArr = Base64.encodeBase64String(arr);
        System.out.println(baseArr);

        // 解密
        byte[] decodeMsg = Base64.decodeBase64(baseArr);
        System.out.println(decodeMsg);

        // 防止出现乱码
        String msg = new String(decodeMsg, StandardCharsets.UTF_8);
        System.out.println(msg);
    }

    @Test
    public void httpBinBase64Test(){
        RestAssured.proxy = host("localhost").withPort(8888);
        RestAssured.useRelaxedHTTPSValidation();

        byte[] arr = "hogwarts".getBytes(StandardCharsets.UTF_8);
        String baseArr = Base64.encodeBase64String(arr);

        String msg =given()
                .formParams("msg", baseArr)
                .when()
                .post("https://httpbin.ceshiren.com/post")
                .then()
                .log().all().extract().path("form.msg");
        System.out.println(msg);

        byte[] decodeMsg = Base64.decodeBase64(msg);
        System.out.println(decodeMsg);

        // 防止出现乱码
        msg = new String(decodeMsg, StandardCharsets.UTF_8);
        System.out.println(msg);

    }
}
