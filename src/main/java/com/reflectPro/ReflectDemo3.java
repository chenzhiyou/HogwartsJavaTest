package com.reflectPro;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Constructor<?>[] getConstructors 获取所有公共的构造函数
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<Person> personClass = Person.class;
        Constructor<?>[] constructors = personClass.getConstructors();
        for (Constructor<?> constructor: constructors){
            System.out.println(constructor);
        }

        // 获取指定的public修饰的构造函数
        Constructor<Person> constructor = personClass.getConstructor(String.class, int.class);
        System.out.println(constructor);
        // 用反射的方式创建对象
        Person person = constructor.newInstance("小赵", 25);
        System.out.println(person);


    }
}
