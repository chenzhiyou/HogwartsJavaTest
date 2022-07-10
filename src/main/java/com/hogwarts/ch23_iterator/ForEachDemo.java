package com.hogwarts.ch23_iterator;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Collection;

/**
 * for(元素类型 变量名: 数组/集合名称){
 *     循环体
 * }
 * 从数组/集合中取出一个元素赋值给变量名并执行循环体，直到取完所有元素为止
 */
public class ForEachDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("hello");
        c1.add("hogwarts");
        c1.add(Integer.valueOf(77));
        c1.add(88);
        c1.add(new Person("小八",178, 23));
        System.out.println("集合C1： "+ c1);
        System.out.println("使用foreach进行循环打印");
        for (Object pbj : c1){
            System.out.println(pbj);
        }

        int[] arr = new int[]{22,44, 55,66, 77};
        for (int i : arr){
            System.out.println(i);
        }
    }

}
