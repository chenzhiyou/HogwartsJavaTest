package com.hogwarts.learn.ch21_synchronization;

import org.checkerframework.checker.units.qual.Temperature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.*;

import java.util.Properties;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelResourceLockTest {

    Properties properties;

    @BeforeEach
    void before(){
        properties = new Properties(System.getProperties());
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ)
    void test1(){
        assertNull(System.getProperty("custom.property"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    void test2(){
        System.setProperty("custom.property", "ceshiren");
        assertEquals("ceshiren", System.getProperty("custom.property"));
    }

    @Test
    @ResourceLock(value = Resources.SYSTEM_PROPERTIES, mode = ResourceAccessMode.READ_WRITE)
    void test3(){
        System.setProperty("custom.property", "hogwarts");
        assertEquals("hogwarts", System.getProperty("custom.property"));
    }
}
