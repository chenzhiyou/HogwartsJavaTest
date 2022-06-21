package com.hogwarts.junit5Basics.ch14_csv;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class CsvUnitTest {

    @Test
    void csvReadWithHeader() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        // 带header进行读取（就是第一行的数据）
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        csvMapper.findAndRegisterModules();

        // readerFor后面是要读成的类型
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderLine.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(orderLines.readAll());
    }

    @Test
    void csvReadWithHeader1() throws IOException {
        CsvMapper csvMapper = new CsvMapper();
        // 带header进行读取（就是第一行的数据）
        CsvSchema orderLineSchema = CsvSchema.emptySchema().withHeader();
        csvMapper.findAndRegisterModules();

        // readerFor后面是要读成的类型
        MappingIterator<OrderLine> orderLines = csvMapper.readerFor(OrderList.class)
                .with(orderLineSchema)
                .readValues(new File("src/test/resources/orderLines.csv"));
        System.out.println(orderLines.readAll());
    }
}
