package com.collectionPro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

class Person{

}

public class CollectionDemo {
    public static void main(String[] args) {
        // 创建对象，接口没有办法new ， 必须创建对应的实现类
        Collection col = new ArrayList();// 可变长度
        // 添加元素
        col.add(123);// 向上转型 int ---> Integer ---> Object
        col.add(true);
        col.add("hello");
        col.add(new Person());

        Collection subCol = new ArrayList();
        subCol.add("1");
        subCol.add("2");
        col.addAll(subCol);// 添加一个集合
        System.out.println(col);
        // contains是否包含某个元素
        boolean contains = col.contains("hello");
        System.out.println("是否包含hello： " + contains);

        // equals 比较的是集合中的内容是否相等
        Collection subCol2 = new ArrayList();
        subCol2.add("1");
        subCol2.add("2");
        boolean equals = subCol2.equals(subCol);
        System.out.println("是否相等： " + equals);
        boolean empty = col.isEmpty();
        System.out.println("集合是否为空: "+ empty);

        // remove 删除某个元素
        col.remove("1");
        System.out.println("删除元素后的集合："+col);
        // 集合中元素的个数
        int size = col.size();
        System.out.println("集合中元素的个数为："+size);

        // 集合转数组
        Object[] objects = col.toArray();
        System.out.println("集合转数组： "+ Arrays.toString(objects));

        // 集合的遍历，不能使用与下标相关的进行比遍历
        for (Object o : col){
            System.out.println("遍历集合中的元素： "+ o);
        }
        // 迭代器，当元素已经取完的时候，hasNext=false，不要在迭代的过程中删除元素，可以使用迭代器去删除元素
        Iterator it = col.iterator();

        while (it.hasNext()){
            Object obj = it.next();
            System.out.println("使用迭代器进行遍历： "+ obj);
//            col.remove("") 不可以使用，会报错
//            it.remove(); // 可以使用迭代器进行元素的删除
        }

        col.clear();
        System.out.println(col);
        empty = col.isEmpty();
        System.out.println("集合是否为空: "+ empty);
    }
}
