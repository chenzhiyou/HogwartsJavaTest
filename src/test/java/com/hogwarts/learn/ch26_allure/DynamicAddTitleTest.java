package com.hogwarts.learn.ch26_allure;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.TestInfo;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("动态更新测试用例标题")
public class DynamicAddTitleTest {

    @TestFactory
    List<DynamicTest> dynamicTests(){
        List<String> inputList = Arrays.asList("apple", "banan", "orange");
        return inputList.stream()
                .map(str -> DynamicTest.dynamicTest("动态测试字符串长度: "+ str,()->{
                            TestInfo testInfo = new TestInfo() {

                                @Override
                                public String getDisplayName() {
                                    return "动态测试字符串长度： " + str;
                                }

                                @Override
                                public Set<String> getTags() {
                                    return null;
                                }

                                @Override
                                public Optional<Class<?>> getTestClass() {
                                    return Optional.empty();
                                }

                                @Override
                                public Optional<Method> getTestMethod() {
                                    return Optional.empty();
                                }
                            };
                            assertEquals(5, str.length(), "Length of "+ str);
                        }))
                .collect(Collectors.toList());
    }
}
