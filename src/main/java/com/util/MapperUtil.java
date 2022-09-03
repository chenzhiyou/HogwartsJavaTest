package com.util;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

/**
 * 文件解析的封装
 * @param <T>
 */
// 解析出来的数据类型
public class MapperUtil<T> implements Serializable {
    public static final long serialVersionUID = 42333L; // 序列化

    ObjectMapper objectMapper;
    // 成员变量
    T readValue;

    public T getReadValue(String pathName) {
        // 解析的业务逻辑
        if (pathName.endsWith(".json")){
            // JSON解析
            objectMapper=  new ObjectMapper(new JsonFactory());
        }else if(pathName.endsWith(".yaml") | pathName.endsWith(".yml")){
            objectMapper = new ObjectMapper(new YAMLFactory());
        }else{
            objectMapper = new ObjectMapper(new XmlFactory());
        }
        TypeReference<T> typeReference = new TypeReference<T>() {};
        try {
            readValue = objectMapper.readValue(new File(pathName), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readValue;
    }
}
