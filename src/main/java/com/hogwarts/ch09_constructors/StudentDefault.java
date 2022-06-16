package com.hogwarts.ch09_constructors;

public class StudentDefault {
    private String name;
    private int grade;

    // 没有构造方法，系统会自动提供默认的构造方法


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
