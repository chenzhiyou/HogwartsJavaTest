package com.hogwarts.ch14_finalp;

/**
 * final修饰的类，不能被继承
 * final修饰的类，可以有父类
 * final不能修饰构造放啊
 * final修饰的方法，不能被子类重写
 */
public class Animal {

    private String name;
    private int sex;
    private int age;

    public Animal(String name, int sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public void sleep(){
        System.out.println("Animal...sleep");
    }

    public Animal(){

    }
}
