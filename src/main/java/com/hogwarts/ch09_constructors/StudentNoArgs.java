package com.hogwarts.ch09_constructors;

public class StudentNoArgs {
    private String name;
    private int grade;

    public StudentNoArgs(){
        System.out.println("这是一个无参的构造方法");
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
