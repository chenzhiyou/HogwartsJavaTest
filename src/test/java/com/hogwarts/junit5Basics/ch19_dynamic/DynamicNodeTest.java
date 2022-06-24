package com.hogwarts.junit5Basics.ch19_dynamic;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 创建动态测试的规则：
 * * 不能是：private、static
 * * 返回类型必须为：Stream、Collection、Iterable、或者Iterator、DynamicNode
 * 动态测试的声明周期：
 * * 在动态测试中，@BeforeEach和@AfterEach声明方法会针对每个@TestFactory方法执行，不会针对每个动态测试执行
 */
public class DynamicNodeTest {

    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("BeforeEach");
    }

    @AfterEach
    void afterEach(){
        System.out.println("afterEach");
    }

    @TestFactory
    @DisplayName("单个动态测试")
    DynamicTest dynamicTest(){
        return DynamicTest.dynamicTest("返回dynamicTest", ()->{
            assertEquals(5, 2+3);
        });
    }

    @TestFactory
    @DisplayName("容器")
    DynamicContainer dynamicContainerTest(){
        return DynamicContainer.dynamicContainer("多个动态测试容器",
                Stream.of(DynamicTest.dynamicTest("加法动态测试",()->{
                    System.out.println("这是一个加法动态测试");
                    assertEquals(6, 3+3);}),
                        DynamicTest.dynamicTest("除法动态测试用例", ()->{
                            assertEquals(5, 25/5);
                        })
                )
        );
    }
    @TestFactory
    Stream<DynamicTest> dynamicTestStream(){
        return Stream.of(5, 6, 7).map(
              arg-> DynamicTest.dynamicTest("Stream流动态测试用例-"+ arg, ()->{
                  System.out.println("参数："+ arg);
                  assertThat(arg, is(greaterThan(2)));
              })
        );
    }

    @TestFactory
    Stream<DynamicContainer> dynamicTestStreams(){
        return Stream.of(5, 6, 7)
                .map(
                    arg ->DynamicContainer.dynamicContainer("多个动态测试容器-"+ arg ,
                        Stream.of(
                                DynamicTest.dynamicTest("Stream动态测试-"+ arg,()->{
                            System.out.println("参数:" + arg);
                            assertThat(arg, is(greaterThan(2)));
                            }),
                                DynamicTest.dynamicTest("Stream动态测试-"+ arg, ()->{
                                    assertThat(arg, is(lessThan(9)));
                                })
                        )
                )
        );
    }

    @TestFactory
    @DisplayName(("动态测试Collection"))
    Collection<DynamicTest> dynamicTestCollection(){
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest = DynamicTest.dynamicTest("add-动态测试", ()->{
            System.out.println("加法动态测试");
        });
        DynamicTest dynamicTest1 = DynamicTest.dynamicTest("sub-减法动态测试", ()->{
            System.out.println("减法动态测试");
        });
        dynamicTests.add(dynamicTest);
        dynamicTests.add(dynamicTest1);
        return dynamicTests;
    }

    // 返回类型为迭代器
    @TestFactory
    @DisplayName("迭代器的动态测试1")
    Iterator<DynamicTest> dynamicTestIterator(){
        Collection<DynamicTest> dynamicTestIterator = new ArrayList<>();
        PrimitiveIterator.OfInt iterator = IntStream.iterate(2, n -> n + 1).limit(3).iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            DynamicTest dynamicTest1 = DynamicTest.dynamicTest("n+1动态测试", ()->{
                System.out.println("n: "+ next);
                assertThat(next, is(greaterThan(1)));
            });

            DynamicTest dynamicTest2 = DynamicTest.dynamicTest("n+1动态测试", ()->{
                System.out.println("n: "+ next);
                assertThat(next, is(greaterThan(4)));
            });
            dynamicTestIterator.add(dynamicTest1);
            dynamicTestIterator.add(dynamicTest2);
        }
        return dynamicTestIterator.iterator();
    }

    @TestFactory
    @DisplayName("迭代器的动态测试")
    Iterable<DynamicTest> dynamicTestIterable() {
        Collection<DynamicTest> dynamicTestIterable = new ArrayList<>();
        PrimitiveIterator.OfInt iterator = IntStream.iterate(2, n -> n + 1).limit(3).iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            DynamicTest dynamicTest1 = DynamicTest.dynamicTest("n+1动态测试", () -> {
                System.out.println("n: " + next);
                assertThat(next, is(greaterThan(1)));
            });

            DynamicTest dynamicTest2 = DynamicTest.dynamicTest("n+1动态测试", () -> {
                System.out.println("n: " + next);
                assertThat(next, is(greaterThan(4)));
            });
            dynamicTestIterable.add(dynamicTest1);
            dynamicTestIterable.add(dynamicTest2);
        }
        return dynamicTestIterable;
    }
}
