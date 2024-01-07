package com.hogwarts.learn.homework.mapper;

import com.hogwarts.learn.homework.entity.AddEntity;
import com.hogwarts.learn.homework.entity.AverageEntity;
import com.jayway.jsonpath.internal.function.numeric.Average;

public enum EntityFileMapping {

    ADD_ENTITY(AddEntity.class, "add-data.yaml"),
    AVERAGE_ENTITY(AverageEntity.class, "average-data.yaml");

    private Class<?> entityClass;
    private String filePath;

    EntityFileMapping(Class<?> entityClass, String filePath){
        this.entityClass = entityClass;
        this.filePath = filePath;
    }

    public Class<?> getEntityCLass(){
        return entityClass;
    }

    public String getFilePath(){
        return filePath;
    }
}
