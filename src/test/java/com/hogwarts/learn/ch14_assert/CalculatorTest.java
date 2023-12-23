package com.hogwarts.learn.ch14_assert;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void test1() throws InterruptedException {
        int add = Calculator.add(1,2);
        assertEquals(9, add);
        add = Calculator.add(5,4);
        assertEquals(9, add);

    }

    /**
     * 使用AssertAll进行断言
     * @throws InterruptedException
     */
    @Test
    void test2() throws InterruptedException {
        int add = Calculator.add(1,2);
        assertAll(
                ()->{
                    System.out.println("这是第一个断言");
                    assertEquals(9, add);},
                ()->{
                    System.out.println("这是第二个断言");
                    assertEquals(3, add);
                }
        );
    }

    /**
     * 借助list进行断言
     * @throws InterruptedException
     */
    @Test
    void test3() throws InterruptedException {
        ArrayList<Executable> executables = new ArrayList<>();
        for (int i = 0; i<10; i++){
            int result = Calculator.add(1, i);
            System.out.println("加法计算结果： "+ result);
            int finalI = i;
            executables.add(()->assertEquals(finalI, result));
        }
        assertAll("执行流", executables.stream());

    }
}
