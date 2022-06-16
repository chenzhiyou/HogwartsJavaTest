package com.hogwarts.ch10_inheri;

public class ConstructorSub extends ConstructorBase{

    public ConstructorSub(){

        super();// 调用父类的构造方法
        System.out.println("子类的构造方法");
    }
}
