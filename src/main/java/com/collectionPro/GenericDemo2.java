package com.collectionPro;


import java.util.ArrayList;
import java.util.List;

class Animal{

}
class Dog extends Animal{

}
/**
 *  ？ 泛型通配符
 */
public class GenericDemo2 {
    // ？ 代表可以匹配任意类型
    public static void test1(List<?> list){

    }
    public static void test2(List<Object> list){

    }

    // 表明集合中的元素只能放Animal和Animal的子类
    public static void test3(List<? extends Animal> list){

    }
    // 表明集合中的元素只能放Animal和Animal的父类
    public static void test4(List<? super Animal> list){

    }
    public static void main(String[] args) {
        List<Dog> list1 = new ArrayList<>();
        test1(list1);
//        test2(list1); 会出现报错
    }
}
