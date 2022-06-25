package com.hogwarts.ch16_accessPermission.one;

/**
 * 在本包中，private的方法是无法使用的，private修饰的方法只能在本类中使用
 * 同一类：本类中无论使用哪个权限修饰符，对应都可以访问并打印成功
 * 同一包：同一个包下对应的调用，对应private修饰的方法会报错，注释掉后，其他方法都可以访问
 * 不同包下的子类：不同包下的子类，可以访问protected和public
 * 不同包下的无关类：不同包下的无关类只能访问public
 */
public class PermissionDemo {
    public static void main(String[] args) {
        Father father = new Father();
//        father.show1();
        father.show2();
        father.show3();
        father.show4();
    }
}
