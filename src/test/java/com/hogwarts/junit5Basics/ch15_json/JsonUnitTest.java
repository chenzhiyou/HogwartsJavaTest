package com.hogwarts.junit5Basics.ch15_json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonUnitTest {

    @Test
    void orderListMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference =
                new TypeReference<List<HashMap<String, Object>>>() {};
        List<HashMap<String, Object>> list = objectMapper.readValue(new File("src/test/resources/orderList.json"), typeReference);
        System.out.println(list);
    }

    @Test
    void orderLineMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<List<OrderLine>> typeReference =
                new TypeReference<List<OrderLine>>() {};
        List<OrderLine> list = objectMapper.readValue(new File("src/test/resources/orderList.json"), typeReference);
        System.out.println(list);
    }

    // 无规则的JSON解析
    @Test
    void orderMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<HashMap<String, Object>> typeReference =
                new TypeReference<HashMap<String, Object>>() {};
        HashMap<String, Object> hashMap = objectMapper.readValue(new File("src/test/resources/order.json"), typeReference);
        System.out.println(hashMap);
    }

    @Test
    void orderObjectMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<Order> typeReference =
                new TypeReference<Order>() {};
        Order order = objectMapper.readValue(new File("src/test/resources/order.json"), typeReference);
        System.out.println(order);
    }
}
