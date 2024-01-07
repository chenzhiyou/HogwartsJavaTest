package com.hogwarts.learn.homework.util;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.hogwarts.learn.homework.mapper.EntityFileMapping;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class TestDataUtil {
    static final String TEST_DATA_FILE_PATH = "src/test/resources/data/";
    static final ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());


    public static <T> List<T> loadYamlData(EntityFileMapping entityFileMap) throws IOException {
        File file = new File(TEST_DATA_FILE_PATH+ entityFileMap.getFilePath());
        TypeFactory typeFactory = objectMapper.getTypeFactory();
        JavaType javaType = typeFactory.constructParametricType(List.class, entityFileMap.getEntityCLass());
        return objectMapper.readValue(file, javaType);
    }

    public static <T> void dumpYamlData(EntityFileMapping entityFileMap, List<T> testDataList) throws IOException {
        if (testDataList.size() == 0){
            throw new IllegalArgumentException("数组长度不能为零");
        }

        if (!testDataList.get(0).getClass().equals(entityFileMap.getEntityCLass())){

            throw new ClassCastException("列表类型与文件不匹配");
        }

        File file = new File(TEST_DATA_FILE_PATH + entityFileMap.getFilePath());
        objectMapper.writeValue(file, testDataList);
    }
}
