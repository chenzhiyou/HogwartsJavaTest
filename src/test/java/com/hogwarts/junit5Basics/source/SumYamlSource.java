package com.hogwarts.junit5Basics.source;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.ceshiren.CalculatorYamlEntity;
import com.hogwarts.ceshiren.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

/**
 * 前提：public修饰数据源方法
 * 数据源在其他类，需要引用格式为：包名.类名#数据源的方法名
 */
public class SumYamlSource {
    public static Stream<CalculatorYamlEntity> sumYamlTest() throws IOException {
        Data data = getYaml();
        List<CalculatorYamlEntity> calculatorYamlEntities = data.getDatas();
        return calculatorYamlEntities.stream();
    }

    private static Data getYaml() throws IOException {
        Data data ;
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        TypeReference<Data> typeReference = new TypeReference<Data>() {
        };
        try {
            data = objectMapper.readValue(
                    new File("src/test/resources/data.yaml"),
                    typeReference);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Test
    @DisplayName("解析yaml文件")
    void calculatorYamlEntity() throws IOException {
        Data data = getYaml();
        System.out.println(data);
    }
}
