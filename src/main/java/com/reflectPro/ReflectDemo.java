package com.reflectPro;

/**
 * 同一个字节码文件(.class)，在一次程序运行过程中，只会被加载一次，不论通过哪一种方式获取class对象都是同一个
 */
public class ReflectDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.reflectPro.Person");
        Class<Person> personClass = Person.class;
        Person p = new Person();
        Class<? extends Person> aClass1 = p.getClass();
        System.out.println("aClass==personClass是否相等"+ (aClass==personClass));
        System.out.println("aClass1==personClass是否相等"+ (aClass1==personClass));
    }
}
