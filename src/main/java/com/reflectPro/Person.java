package com.reflectPro;

@MyAnnotation(age=21)
public class Person {
    private String name;
    private int age;
    public String sex;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat(){
        System.out.println("eat....");
    }

    public void eat(String foodName){
        System.out.println("吃： "+ foodName);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
