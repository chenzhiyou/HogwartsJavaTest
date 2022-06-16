package com.hogwarts.ch10_inheri;

public class HiddenMain {
    public static void main(String[] args) {
        HiddenSub sub = new HiddenSub();
        System.out.println(sub.name);
        sub.showSuper();
        sub.showThis();
    }
}
