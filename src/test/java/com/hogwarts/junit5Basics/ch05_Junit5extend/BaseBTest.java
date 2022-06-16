package com.hogwarts.junit5Basics.ch05_Junit5extend;

import org.junit.jupiter.api.*;

/**
 * BaseBTest 继承于BaseATest
 * 为什么没有变化：因为子类所有的方法名都和父类一样，属于方法的重写
 * 如果解决：使子类的方法名和父类不一致
 * 结果：在执行子类的过程中，父类的所有的带注解的方法也执行了
 * 执行顺序：
 * 用例的执行顺序：先执行父类的测试用例，在执行子类的测试用例
 * all执行顺序：先执行父类的before，->子类的before ->子类的after ->父类的after
 *  1、父类的优先级更高
 *  2、先开始的后结束
 *  3、所有用例开始结束前后执行
 * each的执行顺序：先执行父类的before，->子类的before ->子类的after ->父类的after（在每个用例开始结束前后执行）
 */
public class BaseBTest extends BaseATest{
    @BeforeAll
    static void beforeBAll(){
        System.out.println("BaseBTest --- beforeBAll ");
    }

    @AfterAll
    static void afterBAll(){
        System.out.println("BaseBTest --- afterBAll ");
    }

    @BeforeEach
    void beforeBEach(){
        System.out.println("BaseBTest --- beforeBEach ");
    }

    @AfterEach
    void AfterBEach(){
        System.out.println("BaseBTest --- AfterBEach ");
    }

    @Test
    void hogwarts3(){
        System.out.println("BaseBTest --- hogwarts1测试用例");
    }

    @Test
    void hogwarts4(){
        System.out.println("BaseBTest --- hogwarts2测试用例");
    }
}
