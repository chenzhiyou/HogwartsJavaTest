package com.hogwarts.ch13_poly;

public class Demo {
    public static void main(String[] args) {
        Son son = new Son();
        son.eat();

        // 多态的写法，父类引用指向子类的对象

        Father father = new Son();
        father.eat();
    }
}
