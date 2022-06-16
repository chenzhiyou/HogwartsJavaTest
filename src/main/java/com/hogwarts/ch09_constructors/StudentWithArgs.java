package com.hogwarts.ch09_constructors;

public class StudentWithArgs {
    private String name;
    private int grade;

    // 有参构造方法
    public StudentWithArgs(String name, int grade){
        this.name = name;
        this.grade = grade;
    }

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
