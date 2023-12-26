package com.hogwarts.learn.ch21_synchronization;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class ParallelResourceLock2Test {

    public static final String GLOBAL_USER ="com.hogwarts.learn.ch21_synchronization.User.user";

    @BeforeEach
    void before(){
        User.clear();
    }

    @Test
    @ResourceLock(value = GLOBAL_USER, mode = ResourceAccessMode.READ)
    void test1(){
        assertTrue(User.getUser().isEmpty());
    }

    @Test
    @ResourceLock(value = GLOBAL_USER, mode = ResourceAccessMode.READ_WRITE)
    void test2(){
        User.add(1, "张三");
        System.out.println("test2 => "+ User.getUser());
        assertEquals("张三", User.get(1));
    }

    @Test
    @ResourceLock(value = GLOBAL_USER, mode = ResourceAccessMode.READ_WRITE)
    void test3(){
        User.add(1, "ceshiren");
        System.out.println("test3 => "+ User.getUser());
        assertEquals("ceshiren", User.get(1));
    }

    @Test
    @ResourceLock(value = GLOBAL_USER, mode = ResourceAccessMode.READ_WRITE)
    void test4(){
        User.add(2, "java");
        System.out.println("test4 => "+ User.getUser());
        User.remove(2);
        System.out.println("test4 => "+ User.getUser());
        assertNull(User.get(2));

    }
}
