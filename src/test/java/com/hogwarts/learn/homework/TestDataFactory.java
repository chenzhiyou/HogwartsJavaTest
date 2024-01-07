package com.hogwarts.learn.homework;

import com.hogwarts.learn.homework.entity.AddEntity;
import com.hogwarts.learn.homework.entity.AverageEntity;
import com.hogwarts.learn.homework.mapper.EntityFileMapping;
import com.hogwarts.learn.homework.util.TestDataUtil;

import java.io.IOException;
import java.util.List;

public class TestDataFactory {

    public static List<AddEntity> getAddTestData() throws IOException {
        return TestDataUtil.loadYamlData(EntityFileMapping.ADD_ENTITY);
    }

    public static List<AverageEntity> getAverageTestData() throws IOException {
        return TestDataUtil.loadYamlData(EntityFileMapping.AVERAGE_ENTITY);
    }
}
