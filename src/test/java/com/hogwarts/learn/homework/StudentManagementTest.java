package com.hogwarts.learn.homework;

import learn.ch15_homework.entity.Student;
import learn.ch15_homework.student.StudentManagement;
import learn.ch15_homework.student.StudentManager;
import learn.ch15_homework.student.impl.StudentManagerImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class StudentManagementTest {
    static StudentManager studentManagement ;

    @BeforeAll()
    public static void setUp(){
        studentManagement = new StudentManagerImpl();
        studentManagement.initData();
    }

    @Test
    public void testAddStudent(){
        Integer id = 1001;
        String name = "Tom";
        String sex = "男";
        studentManagement.addStudent(id, name, sex);
        Student student = studentManagement.getStudent(id);
        assertEquals(id, student.getId());
        assertEquals(name, student.getName());
        assertEquals(sex, student.getSex());
    }
}
