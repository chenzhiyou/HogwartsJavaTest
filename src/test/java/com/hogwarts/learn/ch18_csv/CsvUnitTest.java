package com.hogwarts.learn.ch18_csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.hogwarts.learn.ch16_yaml.OrderLine;
import com.hogwarts.learn.ch16_yaml.OrderList;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CsvUnitTest {

    @Test
    void csvReadWithHeader() throws IOException {
        // 带有header的读取
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        // 对日期格式进行处理
        csvMapper.findAndRegisterModules();
        // readFor读成什么类型
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(objectMappingIterator.readAll());
    }

    @Test
    void csvReadWithHeader1() throws IOException {
        // 带有header的读取
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper csvMapper = new CsvMapper();
        // 对日期格式进行处理
        csvMapper.findAndRegisterModules();
        // readFor读成什么类型
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderList.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(objectMappingIterator.readAll());
    }

    @Test
    void csvReadWithHeaderMap() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        csvMapper.findAndRegisterModules();
        CsvSchema build = CsvSchema.builder().setSkipFirstDataRow(true)
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        MappingIterator<Object> objectMappingIterator = csvMapper.readerForMapOf(String.class)
                .with(build)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(objectMappingIterator.readAll());
    }

    @Test
    void csvReadWithNoHeader() throws IOException {
        CsvSchema build = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        CsvMapper csvMapper = new CsvMapper();
        // 对日期格式进行处理
        csvMapper.findAndRegisterModules();

        // readFor读成什么类型
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderLine.class)
                .with(build)
                .readValues(new File("src/test/resources/orderList.csv"));
        System.out.println(objectMappingIterator.readAll());
    }

    @Test
    void csvReadWithOutHeader() throws IOException {
        CsvSchema build = CsvSchema.builder()
                .addColumn("item")
                .addColumn("quantity")
                .addColumn("unitPrice")
                .addColumn("orderDate")
                .build();
        CsvMapper csvMapper = new CsvMapper();
        // 对日期格式进行处理
        csvMapper.findAndRegisterModules();

        // readFor读成什么类型
        MappingIterator<Object> objectMappingIterator = csvMapper.readerFor(OrderList.class)
                .with(build)
                .readValues(new File("src/test/resources/orderList.csv"));
        System.out.println(objectMappingIterator.readAll());
    }
}
