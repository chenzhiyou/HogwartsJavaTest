package com.hogwarts.junit5Basics.ch07_junit5timeout;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * timeout注解内的参数是以秒为单位的
 */
public class TimeOutExampleTest {

    @BeforeEach
//    @Timeout(3)
    void setup() throws InterruptedException {
//        sleep(4000);
        System.out.println("测试开始");
    }

    @AfterEach
    void teardown() throws InterruptedException {
//        sleep(4000);
        System.out.println("结束开始");
    }

    @Test
    @Timeout(value = 3, unit = SECONDS)
    void timeoutCaseOne() throws InterruptedException {
        System.out.println("第一条用例");
//        sleep(10000);
    }

    @Test
    @Timeout(3)
    void timeoutCaseTwo(){
        System.out.println("第二条用例");
    }
}
