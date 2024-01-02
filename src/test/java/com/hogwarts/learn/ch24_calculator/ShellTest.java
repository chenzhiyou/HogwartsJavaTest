package com.hogwarts.learn.ch24_calculator;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import learn.ch36_calculator.entity.ResultList;
import learn.ch36_calculator.entity.ShellResult;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ShellTest {
    ResultList resultList;

    private ResultList getShellYaml(){

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TypeReference<ResultList> typeReference =  new TypeReference<ResultList>(){};
        try {
            resultList = mapper.readValue(new File("src/test/resources/shell_test_result.yaml"), typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(resultList);
        return resultList;
    }

    //动态测试工厂:返回值不是Collection、Stream、Itearator，是其他类型，则会报错 JunitException异常
    @TestFactory
    Collection<DynamicTest> shellDynamic(){
        Collection<DynamicTest> shellDyList = new ArrayList<>();
        ResultList shellYaml = getShellYaml();
        List<ShellResult> results = shellYaml.getResultList();
        results.forEach(
                shellResult -> {
                    // 直接导入静态包
                    DynamicTest dynamicTest = dynamicTest(shellResult.getCaseName(),
                            // 测试业务逻辑
                            () -> assertTrue(shellResult.getResult()));
                    shellDyList.add(dynamicTest);
                }
        );
        return shellDyList;
    }


}
