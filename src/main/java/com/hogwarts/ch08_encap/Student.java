package com.hogwarts.ch08_encap;

public class Student {
    private String name;
    private int age;
    private String gender;

    public String getName() {
        this.show();
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public void show(){
        System.out.println("这是一个成员方法");
    }
}
