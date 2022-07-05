package com.hogwarts.ch22_collectionandmap;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 集合框架顶层是：java.util.Collection和java.util.Map
 * Collection集合存取是：单个元素
 * Map集合中存取的是：单对元素
 * Collection集合(是一个接口)：
 *      是List、Queue及Set接口的父类接口
 *      boolean add(E e) 集合内添加对象
 *      boolean addAll(Collection<? extends E>) 将集合C所有元素添加到集合内
 *      集合中添加单个元素或者单个对象，使用add()
 *      集合中添加多个元素，使用addAll()
 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(new String("hello"));
        c1.add("collection");
        c1.add(Integer.valueOf(77));
        c1.add(88);

        // 添加对象
        c1.add(new Person("小7", 178, 22));
        System.out.println(c1);

        Collection c2 = new ArrayList();
        c2.add(86);
        c2.add("java");
        System.out.println("c2:"+ c2);

        // 将C2的元素一个一个加入到C1中
        boolean b = c1.addAll(c2);
        System.out.println("添加是否成功:"+ b);
        System.out.println("c1: "+ c1);

        // 将C2当做一个整体添加进入到C1中
        boolean add = c1.add(c2);
        System.out.println("添加是否成功:"+ add);
        System.out.println("c1:" + c1);


    }


}
