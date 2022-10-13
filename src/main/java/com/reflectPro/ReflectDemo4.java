package com.reflectPro;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        Method[] methods = personClass.getMethods();
        for (Method method:methods){
            System.out.println(method);
        }
        Method eat = personClass.getMethod("eat");
        Method eatStr = personClass.getMethod("eat", String.class);
        System.out.println("eat方法： "+ eat);
        System.out.println(eatStr);
        // 通过反射的方式调用方法
        Person person = personClass.newInstance();
        eatStr.invoke(person, "鱼");

        System.out.println("=============================");
        // 获取所有的方法公有和私有的，但是不包括父类的
        Method[] declaredMethods = personClass.getDeclaredMethods();
        for (Method declaredMethod :declaredMethods){
            System.out.println(declaredMethod);
        }

    }
}
