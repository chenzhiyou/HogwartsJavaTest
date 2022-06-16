package com.hogwarts.ch07_oop;

public class PersonDemo {
    public static void main(String[] args) {
        Person zhangsan = new Person("张三", 180, 23);
        Person lisi = new Person("李四", 165, 32);

        zhangsan.meet(lisi.name);
        System.out.println(lisi.name);
        zhangsan.eat();
        zhangsan.sleep();
    }
}
