package com.hogwarts.ch18_inner;

/**
 * 静态内部类：
 *      调用方式：外部类名.内部类名 内部类实例名 = new 外部类名.内部类名();
 *      特点：
 *          静态内部类不能直接访问外部类的非静态成员
 *          静态内部类，可以直接创建对象
 *          如果静态内部类访问外部类中与本类内同名的成员变量或方法时，需要使用类名.的方式访问
 *      总结：
 *          有static就是类层级，类名.调用
 *          没有static就是对象层级，引用.调用
 */
public class StaticInnerDemo {
    private int id = 1;
    private static int sid = 2;

    public static class StaticInner{
        private int sinId = 3;
        private static int sid = 4;

        /**
         * 定义静态内部类
         */
        public StaticInner(){
            System.out.println("静态内部类StaticInner的构造方法");
        }

        public void show(){
            System.out.println("外部类StaticInnerDemo的静态成员变量sid值是： "+sid);
            System.out.println("静态内部类StaticInner的成员变量sidId的值是： " +sinId);
        }

        public void show2(int sid){
            System.out.println("形参变量sid： " + sid);
            System.out.println("静态内部类StaticInner的静态成员变量sid的值是： "+ StaticInner.sid);
            System.out.println("外部类StaticInnerDemo的静态成员变量sid的值是： "+ StaticInnerDemo.sid);
        }
    }
}
