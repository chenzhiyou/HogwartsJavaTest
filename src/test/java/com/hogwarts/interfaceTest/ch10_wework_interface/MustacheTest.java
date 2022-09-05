package com.hogwarts.interfaceTest.ch10_wework_interface;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.codes.DefaultMustache;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.HashMap;

public class MustacheTest extends BaseTest{

    // 模板解析到新的JSON文件
    @Test
    public void jsonWithMustache(){
        // 1、 HashMap<> 要修改的字段存入map中
        HashMap<String, Object> hashMap = new HashMap<String, Object>(){{
            put("departmentName", "11111");
            put("orderId", "2222");
        }};

        DefaultMustacheFactory defaultMustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = defaultMustacheFactory.compile("department4.mustache");
        try {
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(
                            new FileOutputStream("src/test/resources/department4.json"));
            mustache.execute(outputStreamWriter, hashMap);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 模板解析到变量
    @Test
    public void jsonWithMustacheWithStr(){
        // 1、 HashMap<> 要修改的字段存入map中
        HashMap<String, Object> hashMap = new HashMap<String, Object>(){{
            put("departmentName", "11111");
            put("orderId", "2222");
        }};

        DefaultMustacheFactory defaultMustacheFactory = new DefaultMustacheFactory();
        Mustache mustache = defaultMustacheFactory.compile("department4.mustache");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(byteArrayOutputStream);
        mustache.execute(writer, hashMap);
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String finalStr = new String(byteArrayOutputStream.toByteArray());
        System.out.println(finalStr);
    }
}
