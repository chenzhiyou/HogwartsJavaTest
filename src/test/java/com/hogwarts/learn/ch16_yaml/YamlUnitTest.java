package com.hogwarts.learn.ch16_yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class YamlUnitTest {

    /**
     * 直接声明数据结构
     * @throws IOException
     */
    @Test
    void listTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        // 对应的解析类型声明
        TypeReference<List<HashMap<String, Object>>> typeReference = new TypeReference<List<HashMap<String, Object>>>() {
        };
        List<HashMap<String, Object>> list = objectMapper.readValue(new File("src/test/resources/orderList.yaml"), typeReference);

        System.out.println(list);
    }

    /**
     * 实体类声明
     * @throws IOException
     */
    @Test
    void orderListTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        // 为了正常的处理声明的日期
        objectMapper.findAndRegisterModules();
        TypeReference<List<OrderList>> typeReference = new TypeReference<List<OrderList>>() {
        };
        List<OrderList> orderLists = objectMapper.readValue(new File("src/test/resources/orderList.yaml"), typeReference);
        System.out.println(orderLists);
    }

    /**
     * 实体类的成员变量与key一一对应
     */

    @Test
    void orderLineTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<List<OrderLine>> typeReference =
                new TypeReference<List<OrderLine>>() {
        };
        List<OrderLine> orderLists = objectMapper.readValue(new File("src/test/resources/orderList.yaml"), typeReference);
        System.out.println(orderLists);

    }
}
