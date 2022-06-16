package com.hogwarts.junit5Basics.ch04_junit5assert;

import org.junit.jupiter.api.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTimeout;

public class AssertsTimeoutDemo {

    @Test
    void testAssertTimeOut(){
        // 第一个参数传递超时时间，Duration.ofSeconds(5)，代表5秒超时
        // 第二个参数传递操作
        // 如果第二个参数超出第一个参数限定的时间范围，那么就是超时，就会抛出异常
        assertTimeout(Duration.ofSeconds(5), ()->{
            sleep(3000);
        });
    }
}
