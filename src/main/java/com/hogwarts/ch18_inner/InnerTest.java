package com.hogwarts.ch18_inner;

public class InnerTest {
    public static void main(String[] args) {
        // 外部类实例化
        NormalInnerDemo normalInnerDemo = new NormalInnerDemo();
        // 普通内部类实例化
        NormalInnerDemo.NormalInner normalInner = normalInnerDemo.new NormalInner();
        // 调用show方法
        normalInner.show();
        normalInner.show2(3);

    }
}
