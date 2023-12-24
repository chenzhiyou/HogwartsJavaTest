package com.hogwarts.learn.ch19_json;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hogwarts.learn.ch16_yaml.OrderLine;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class JsonUnitTest {

    @Test
    void OrderListTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        TypeReference<List<HashMap<String, Object>>> typeReference =
                new TypeReference<List<HashMap<String, Object>>>() {
                };
        objectMapper.findAndRegisterModules();
        List<HashMap<String, Object>> hashMaps = objectMapper.readValue(new File("src/test/resources/orderList.json"), typeReference);
        System.out.println(hashMaps);
    }

    @Test
    void OrderLineTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<List<OrderLine>> typeReference =
                new TypeReference<List<OrderLine>>() {
                };
        objectMapper.findAndRegisterModules();
        List<OrderLine> orderLines = objectMapper.readValue(new File("src/test/resources/orderList.json"), typeReference);
        System.out.println(orderLines);
    }

    @Test
    void orderMap() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<HashMap<String, Object>> typeReference =
                new TypeReference<HashMap<String, Object>>() {
                };
        HashMap<String, Object> hashMap = objectMapper.readValue(new File("src/test/resources/order.json"), typeReference);
        System.out.println(hashMap);
    }

    @Test
    void orderTest() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());
        objectMapper.findAndRegisterModules();
        TypeReference<Order> typeReference =
                new TypeReference<Order>() {
                };
        Order order = objectMapper.readValue(new File("src/test/resources/order.json"), typeReference);
        System.out.println(order);
    }
}
