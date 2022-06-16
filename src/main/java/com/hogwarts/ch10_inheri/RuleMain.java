package com.hogwarts.ch10_inheri;

/**
 * 子类只能访问父类非私有的方法
 */
public class RuleMain {
    public static void main(String[] args) {
        RuleSub sub = new RuleSub();
        sub.name = "子类";
        sub.eat();
    }
}
