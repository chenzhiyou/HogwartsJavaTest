package com.reflectPro;

import java.lang.reflect.Field;

/**
 * Field[] getFields():获取所有public修饰的成员变量
 * Field getField(String name): 获取指定名称的public修饰的成员变量
 * Field[] getDeclaredFields(): 获取所有的成员变量，不考虑修饰符
 * Field[] getDeclaredFields(String name)
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person();
        // 1、第一步获取class类的对象
        Class<Person> personClass = Person.class;
        Field[] fields = personClass.getFields();
        for (Field field: fields){
            System.out.println(field);
        }
        // 通过反射的方式进行设值
        Field sex = personClass.getField("sex");
        // 设值
        sex.set(person, "男");
        System.out.println(sex);
        System.out.println("sex的值为"+ sex.get(person));
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField: declaredFields){
            System.out.println("所有声明过的："+ declaredField);
        }
        Field name = personClass.getDeclaredField("name");
        // 通过反射给被private修饰的属性赋值
        name.setAccessible(true);
        name.set(person, "小王");
        System.out.println("name的值为: "+name.get(person) );
        System.out.println("name:" + name);
        System.out.println("========================");

    }
}
