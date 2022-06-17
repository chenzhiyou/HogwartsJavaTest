package com.hogwarts.junit5Basics.ch08_junit5casename;

import org.junit.jupiter.api.*;

/**
 * 指定排序方式为通过Order注解排序， 注意需要和@Order注解一起使用
 * DisplayName,通过displayName的进行排序, 需要和@DisplayName("1")进行结合
 * @TestMethodOrder(MethodOrderer.Random.class) 随机进行排序
 * @TestMethodOrder(MethodOrderer.MethodName.class) 通过方法名称进行排序
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class OrderExampleTest {

    @Test
//    @Order(1)
//    @DisplayName("1")
    void HogwartsOne(){
        System.out.println("第1条测试用例");
    }

    @Test
//    @Order(2)
//    @DisplayName("2")
    void HogwartsTwo(){
        System.out.println("第2条测试用例");
    }

    @Test
//    @Order(3)
//    @DisplayName("3")
    void HogwartsThree(){
        System.out.println("第3条测试用例");
    }

    @Test
//    @Order(4)
//    @DisplayName("4")
    void HogwartsFour(){
        System.out.println("第4条测试用例");
    }
}
