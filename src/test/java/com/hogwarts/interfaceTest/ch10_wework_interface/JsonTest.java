package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class JsonTest {

    @Test
    public void jsonPathTest(){
        try {
            // 1、JSONPath parse()方法去进行JSON文件的解析
            DocumentContext context = JsonPath.parse(new File("src/test/resources/department3.json"));
            // 2、使用set方法进行JSONPath语法解析的结果修改 context.set(JsonPath路径，要修改后的值)
            context.set("$.name", "00000");
            context.set("$.order", "22222");
            String jsonString = context.jsonString();
            System.out.println(jsonString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
