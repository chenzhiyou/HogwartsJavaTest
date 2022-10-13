package com.reflectPro;

import java.lang.reflect.Method;

/**
 * 在程序使用(解析)注解：获取注解中定义的属性值
 * 获取注解定义的位置的对象(class, Method, Field) isAnnotationPresent(class)
 * 获取指定的注解 getAnnotation(class)
 * 调用注解中的抽象方法获取配置的属性值
 */
public class ReflectDemo5 {
    public static void main(String[] args) throws NoSuchMethodException {
        Class<Person> personClass = Person.class;
        // 判断是否使用注解
        boolean annotationPresent = personClass.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent){
            MyAnnotation annotation = personClass.getAnnotation(MyAnnotation.class);
            System.out.println(annotation);
            int age = annotation.age();
            System.out.println("年龄是: "+ age);
        }

        // 获取定义在方法上的注解
        Method eat = personClass.getMethod("eat");
        boolean annotationPresent1 = eat.isAnnotationPresent(MyAnnotation.class);
        if (annotationPresent1){
            MyAnnotation annotation = eat.getAnnotation(MyAnnotation.class);
            int age = annotation.age();
            System.out.println("年龄是: "+ age);
        }

    }
}
