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
 *      boolean add(E e) 集合内添加对象 添加的是集合对象
 *      boolean addAll(Collection<? extends E>) 将集合C所有元素添加到集合内  添加的是集合中的每个元素
 *      集合中添加单个元素或者单个对象，使用add()
 *      集合中添加多个元素，使用addAll()
 *      boolean contains(Object o) 判断集合是否包含指定对象
 *      总结：
 *          Integer、String对应的Java里面就给重写equals方法
 *          自定义的类没有重写equals方法
 *      boolean containsAll(Collection<?> c) 判断集合是否包含指定集合内的所有对象
 *
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

        System.out.println("-------------是否包含验证-------------------");
        boolean b1 = c1.contains("hello");
        System.out.println("是否包含hello:"+ b1);

        b1 = c1.contains("hogwarts");
        System.out.println("是否包含hogwarts:"+ b1);

        b1 = c1.contains(88);
        System.out.println("是否包含88:"+ b1);
        b1 = c1.contains(8);
        System.out.println("是否包含8:"+ b1);

        b1 = c1.contains(new Person("小7", 178, 22));
        System.out.println("是否包含Person对象： "+ b1);

        Collection c3 = new ArrayList();
        c3.add(77);
        c3.add("hogwarts");
        boolean b2 = c1.containsAll(c3);
        System.out.println("c1:" + c1);
        System.out.println("c3:" + c3);
        // C1里面不是完全包含C3，所以返回结果就会为FALSE
        System.out.println("C1里面是否包含C3： "+ b2);

        Collection c4 = new ArrayList();
        c4.add(86);
        c4.add("collection");
        System.out.println("C4: "+ c4);
        // 是没有顺序的区分的
        boolean b3 = c1.containsAll(c4);
        System.out.println("C1里面是否包含C4中的每一个元素: "+ b3);
        b2 = c1.contains(c4);
        System.out.println("C1中是否包含C4这个集合： " +b2);

        Collection c5 = new ArrayList();
        c5.add(66);
        c5.add("good");
        System.out.println("C5: "+ c5);
        boolean add1 = c1.add(c5);
        System.out.println("c1添加C5： "+ add1);
        System.out.println("c1: "+ c1);

    }
}
