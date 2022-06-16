package com.hogwarts.ch09_constructors;

public class Demo {
    public static void main(String[] args) {
        System.out.println("没有构造方法的时候");
        StudentDefault hogwarts = new StudentDefault();
        System.out.println(hogwarts.getName());
        System.out.println(hogwarts.getGrade());


        StudentNoArgs noArgs = new StudentNoArgs();
        System.out.println(noArgs.getName());
        System.out.println(noArgs.getGrade());

        StudentWithArgs withArgs = new StudentWithArgs("hogwarts", 666);
        System.out.println(withArgs.getName());
        System.out.println(withArgs.getGrade());

    }
}
