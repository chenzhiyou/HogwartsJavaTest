package com.hogwarts.learn.ch22_dynamic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.PrimitiveIterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicNodeTest {

    @TestFactory
    DynamicTest dynamicTest(){
        return DynamicTest.dynamicTest("返回值类型为DynamicTest：", ()->{
            assertEquals(5, 3+2);
        });
    }

    @TestFactory
    @DisplayName("容器")
    DynamicContainer dynamicContainerTest(){
        return DynamicContainer.dynamicContainer("多个动态测试的容器：",
                Stream.of(
                        DynamicTest.dynamicTest("返回值类型为DynamicTest：", ()->{
                    assertEquals(5, 3+2);
                }),
                        DynamicTest.dynamicTest("返回值类型为DynamicTest：", ()->{
                            assertEquals(5, 25/5);
                        }))
                );
    }

    @TestFactory
    @DisplayName("动态测试stream")
    Stream<DynamicTest> dynamicStreamTest(){
        return Stream.of(5, 6, 7).map(
                arg->
                    DynamicTest.dynamicTest("Stream动态测试", ()->{
                        System.out.println("参数为："+ arg);
                        assertThat(arg, is(greaterThan(2)));
                    })
        );
    }

    @TestFactory
    Stream<DynamicContainer> dynamicStreamsTest(){
        return Stream.of(5, 6, 7)
                .map(
                        arg->DynamicContainer.dynamicContainer("容器"+arg,
                                Stream.of(
                                        DynamicTest.dynamicTest("Stream动态测试", ()->{
                                                    System.out.println("参数为："+ arg);
                                                    assertThat(arg, is(greaterThan(2)));
                                                }),
                                        DynamicTest.dynamicTest("Stream动态测试", ()->{
                                            System.out.println("参数为："+ arg);
                                            assertThat(arg, is(lessThan(10)));
                                        })
                                )
                        )
                );
    }

    @TestFactory
    @DisplayName("动态测试Collection")
    Collection<DynamicTest> dynamicCollectionTest(){
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        DynamicTest dynamicTest = DynamicTest.dynamicTest("add-动态测试", ()->{
            System.out.println("动态测试用例");
        });

        DynamicTest dynamicTest2 = DynamicTest.dynamicTest("sub-动态测试", ()->{
            System.out.println("动态测试用例");
        });
        dynamicTests.add(dynamicTest);
        dynamicTests.add(dynamicTest2);
        return dynamicTests;
    }

    // 返回类型为迭代器
    @TestFactory
    @DisplayName("迭代器的动态测试")
    Iterator<DynamicTest> dynamicIteratorTest(){
        Collection<DynamicTest> dynamicTests = new ArrayList<>();
        PrimitiveIterator.OfInt iterator = IntStream.iterate(2, n->n+1).limit(3).iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            DynamicTest dynamicTest1 = DynamicTest.dynamicTest("n+1动态测试", ()->{
                System.out.println("n: "+ next);
                assertThat(next, is(greaterThan(1)));
            });
            DynamicTest dynamicTest2 = DynamicTest.dynamicTest("2.n+1动态测试", ()->{
                System.out.println("n2: "+ next);
                assertThat(next, is(greaterThan(4)));
            });
            dynamicTests.add(dynamicTest1);
            dynamicTests.add(dynamicTest2);
        }
        return dynamicTests.iterator();
    }

}
