package com.hogwarts.ch10_inheri;

/**
 * 方法重写
 */
public class OverrideMain {
    public static void main(String[] args) {
        OverrideSub sub = new OverrideSub();

        sub.live();
        sub.doSuper();
        sub.doThis();
    }
}
