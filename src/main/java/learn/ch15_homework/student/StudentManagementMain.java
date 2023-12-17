package learn.ch15_homework.student;

import learn.ch15_homework.student.StudentManagement;
import learn.ch15_homework.student.impl.StudentManagerImpl;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentManagementMain {
    public static void main(String[] args) {
//        StudentManagement studentManagement = new StudentManagement();
//        studentManagement.run();
        // 基于面向接口编程的调用
        new Client(new StudentManagerImpl()).run();
    }
}
