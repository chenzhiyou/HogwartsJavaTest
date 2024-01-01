package com.hogwarts.learn.ch24_calculator.source;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import learn.ch36_calculator.entity.Data;
import learn.ch36_calculator.entity.dataEntity;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

public class SumYamlSource {
    // 引用的数据源一定要是public修饰
    public static Stream<dataEntity> sumParaYaml() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        Data data;
        TypeReference<Data> typeReference =
                new TypeReference<Data>() {
                };
        data = objectMapper.readValue(new File("src/test/resources/data.yaml"), typeReference);
//        List<dataEntity> datas = data.getDatas();
        return data.getDatas().stream();
    }
}
