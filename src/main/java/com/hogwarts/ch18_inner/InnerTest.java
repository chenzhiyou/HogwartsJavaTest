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
        // 静态内部类调用方式：外部类名.内部类名 内部类实例名 = new 外部类名.内部类名();
        StaticInnerDemo.StaticInner staticInner = new StaticInnerDemo.StaticInner();
        staticInner.show();
        staticInner.show2(5);
        System.out.println("--------------局部内部类--------------");
        AreaInnerClassDemo areaInnerClassDemo = new AreaInnerClassDemo();
        areaInnerClassDemo.show();
    }
}
