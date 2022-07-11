package com.hogwarts.ch24_list;

import java.util.ArrayList;
import java.util.List;

/**
 * java.util.List集合是Collection集合的子集合
 * List集合中允许有重复的元素并且有先后放入次序
 * List集合的主要实现类有：ArrayList类、LinkedList类、Stack类、Vector类
 *      ArrayList类的底层是采用动态数组进行数据管理的，支持下标访问，增删元素不方便
 *      LinkedList类的底层是采用双向链表进行数据管理的，访问不方便，增删元素方便
 *      Stack类的底层是采用动态数组进行数据管理的，主要管理的是后进先出特征的数据结构，叫做栈
 *      Vector类是比ArrayList类更线程安全的类，但是效率比较低，已过时，每次扩容是2倍
 * 数组的特点：
 *      一块连续的存储内存的空间
 *      只存放具体数据
 * 常用方法；
 *      void add(int index, E element) 向集合中指定位置添加元素
 *      boolean addAll(int index, Collection<? extends E> c) 向集合中添加所有元素
 *      E get(int index) 从集合中获取指定位置元素
 *      int indexOf(Object o) 查找参数指定的对象
 *      int lastIndexOf(Object o) 反向查找参数指定的对象
 *      E set(int index, E element) 修改指定位置的元素
 *      E remove(int index) 删除指定位置的元素
 *      List subList(int fromIndex, int toIndex) 用于获取子list
 */
public class ListDemo {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        // 添加元素
        list.add("one");
        list.add("two");
        System.out.println(list);
        list.add(0, "one");
        list.add(1, "two");

        System.out.println(list);

        List ls = new ArrayList();
        ls.add("hello");
        ls.add("list");

        System.out.println("ls= " + ls);
        System.out.println("--------------addAll--------------");
        ls.addAll(2, list);
        System.out.println("ls= " + ls);
        System.out.println("-------------get-------------");
        Object o = ls.get(2);
        System.out.println("获取到的元素对象为： "+o);
        // .ClassCastException 类型转换错误，对应的编译正常，运行错误

        System.out.println("----------get重新toString------------");
        System.out.println("ls= "+ ls);
        System.out.println("list集合的长度"+ ls.size());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int size = ls.size();
        for (int i = 0; i<size; i++){
            Object o2 = ls.get(i);
            if (size -1 == i){
                stringBuilder.append(o2).append("]");
            }else {
                stringBuilder.append(o2).append(",").append(" ");
            }

        }
        System.out.println("stringBuilder:" +stringBuilder);
        System.out.println("-----------元素出现的索引位置-----------");
        int index = ls.indexOf("hello");
        System.out.println("hello元素的下标为: " + index);

        System.out.println("-----------set修改元素--------------");
        Object setOne = ls.set(3, 2);
        System.out.println("ls集合为： "+ ls);

        System.out.println("-----------删除指定元素-------------");
        int size1 = ls.size();
        for (int i = (ls.size()-1); i >=0; i--){
            System.out.println("被删除的元素" + ls.remove(i));
        }
        System.out.println("ls的元素为： "+ ls);

    }
}
