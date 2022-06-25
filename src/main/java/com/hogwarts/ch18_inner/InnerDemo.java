package com.hogwarts.ch18_inner;

/**
 * 内部类：一个类的定义出现在另外一个类，那么这个出现的类就叫内部类(inner)，内部类所在的类叫做外部类(outer)
 * 应用特点：
 *      一个类对应提供的内容仅仅是为某一个类单独服务
 *      可以直接访问外部类的私有的成员变量
 * 分类：
 *      普通内部类：直接将一个类的定义放在另外一个类的类体重
 *          调用方式：外部类 外部类实例名 = new 外部类名();
 *                  外部类名.内部类名 内部类实例名 = 外部类实例名.new 内部类名();
 *          特点：
 *              普通内部类和普通类一样
 *              普通内部类权限修饰符都可以用
 *              创建调用普通内部类，需要外部类实例对象来创建内部类对象
 *              final可修饰外部类
 *      静态内部类：使用static修饰的内部类，属于类层级
 *      局部内部类：直接将一个类的定义放在方法体的内部
 *      匿名内部类：就是指没有名字的内部类
 */
public class InnerDemo {
}
