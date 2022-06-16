package com.hogwarts.ch11_abstract;

public abstract class RuleOne {
    // 想在一个类中使用抽象方法，这个类必须是抽象类
    // 抽象类中可以没有抽象方法
    // 在抽象类中可以有构造方法，抽象类的构造方法不能创建实例
    public abstract void eat();

    String color ;

    public RuleOne(){
        color = "白色";
        System.out.println("抽象类的构造方法");
    }
}
