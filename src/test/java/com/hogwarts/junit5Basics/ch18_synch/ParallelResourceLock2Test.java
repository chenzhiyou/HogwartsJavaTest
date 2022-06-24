package com.hogwarts.junit5Basics.ch18_synch;

import com.hogwarts.ch15_entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.ResourceAccessMode;
import org.junit.jupiter.api.parallel.ResourceLock;

import static org.junit.jupiter.api.Assertions.*;

public class ParallelResourceLock2Test {

    public static final String GLOBAL_USER = "com.hogwarts.ch15_entity.User.user";
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
    void test2(){
        User.add(1, "gaigai");
        System.out.println("test2 =>"+ User.getUser());
        assertEquals("gaigai", User.get(1));
    }

    @Test
    void test3(){
        User.update(1, "ceshiren");
        System.out.println("test3 =>"+ User.getUser());
        assertEquals("ceshiren", User.get(1));
    }

    @Test
    void test4(){
        User.add(2, "java");
        System.out.println("test4 =>"+ User.getUser());
        User.remove(2);
        System.out.println("test4 =>"+ User.getUser());
        assertNull(User.get(2));
    }
}
