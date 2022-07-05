package com.hogwarts.ch07_oop;

/**
 * Person类
 */
public class Person {
    // 属性
    Integer height;
    String name;
    Integer age;
    // 行为 --- 方法

    public Person(String name, Integer height, Integer age){
        //构造方法
        this.name = name;
        this.height = height;
        this.age = age;
    }
    public void sleep(){
        System.out.println("睡觉啦");
    }

    public void eat(){
        System.out.println("吃饭啦");
    }

    public void meet(String meetPersonName){
        System.out.println(name + "遇见了" + meetPersonName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
