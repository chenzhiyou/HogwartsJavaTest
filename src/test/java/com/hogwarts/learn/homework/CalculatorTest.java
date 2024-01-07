package com.hogwarts.learn.homework;

import com.hogwarts.learn.homework.entity.AddEntity;
import com.hogwarts.learn.homework.entity.AverageEntity;
import com.hogwarts.learn.homework.mapper.EntityFileMapping;
import com.hogwarts.learn.homework.util.TestDataUtil;
import io.qameta.allure.Description;
import learn.ch36_calculator.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToObject;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.slf4j.LoggerFactory.getLogger;

@DisplayName("计算器测试")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CalculatorTest {
    static final Logger logger= getLogger(CalculatorTest.class);
    public static Calculator calculator;

    @BeforeAll
    public static void init() throws IOException {
        calculator = new Calculator("计算器");
        List<AddEntity> addEntities = new ArrayList<>();
        addEntities.add(new AddEntity(new int[]{98, -98}, 0));
        addEntities.add(new AddEntity(new int[]{98, 98}, 196));
        addEntities.add(new AddEntity(new int[]{-98, -98}, -196));
        addEntities.add(new AddEntity(new int[]{98, 98,  98, 98, 98}, 490));

        List<AverageEntity> averageEntities = new ArrayList<>();
        averageEntities.add(new AverageEntity(new int[]{99, -99}, 0.0));
        averageEntities.add(new AverageEntity(new int[]{99, 99}, 99.0));
        averageEntities.add(new AverageEntity(new int[]{-99, -99}, -99.0));
        averageEntities.add(new AverageEntity(new int[]{2, 3}, 2.5));

        TestDataUtil.dumpYamlData(EntityFileMapping.ADD_ENTITY, addEntities);
        TestDataUtil.dumpYamlData(EntityFileMapping.AVERAGE_ENTITY, averageEntities);
    }

    @AfterEach
    public void close(){
        calculator.close();
    }

    @Test
    @Order(1)
    public void addOrderOne(){
        Integer result = calculator.sum(1,5);
        logger.info("计算结果为： {}", result);
        assertEquals(6, result, "计算结果失败");
    }

    @Test
    @Order(2)
    public void averageOrderTwo(){
        Double result = calculator.average(1, 5);
        logger.info("计算结果为： {}", result);
        assertEquals(6, result, "计算结果失败");
    }

    @Test
    public void assertTest(){
        int result = calculator.sum(1, 3, 5);
        ArrayList<Executable> assertList = new ArrayList<>();

        assertList.add(()-> assertThat(result, equalToObject(9)));
        assertList.add(()-> assertThat(result, equalToObject(0)));
        assertList.add(()-> assertThat(result, equalToObject(10)));
        assertAll(assertList);
    }

    @ParameterizedTest
    @MethodSource("com.hogwarts.learn.homework.TestDataFactory#getAddTestData")
    @DisplayName("相加功能")
    @Description("使用yaml文件进行添加功能的等价类、边界值冒烟测试")
    public void addYamlTest(AddEntity addEntity){
        assertEquals(calculator.sum(addEntity.getAddNumbers()), addEntity.getExpect());
    }

    @ParameterizedTest
    @MethodSource("com.hogwarts.learn.homework.TestDataFactory#getAverageTestData")
    @DisplayName("平均值功能")
    @Description("使用yaml文件进行平均值功能的等价类、边界值冒烟测试")
    public void averageYamlTest(AverageEntity averageEntity){
        assertEquals(calculator.average(averageEntity.getAverageNums()), averageEntity.getExpect());
    }
}
