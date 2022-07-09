package com.hogwarts.ch23_iterator;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * java.util.Iterator接口
 *      描述迭代器对象
 *      遍历Collection集合中的所有对象
 *      常用方法：
 *          boolean hasNext() 判断集合中是否有可以迭代/访问的元素
 *          E next()  用于取出一个元素并指向下一个元素
 *          void remove() 用于删除访问到的最后一个元素
 *      ConcurrentModificationException报错：
 *          当这种修改是不允许的，检测到对象的并发修改的方法可能会抛出此异常。
 *          例如：通常不允许一个线程在另一个线程对其进行迭代时修改Collection，一般来说，在这些情况下，迭代的结果是不确定的。
 *          如果检测到此行为，某些迭代器实现(包括JRE提供的所有通用集合实现的那些)可能会抛出此异常。这样做的迭代器被称为快速
 *          失败迭代器。因为它们快速二干净的失败，而不是在未来不确定的时间冒出任意的、非确定性的行为的风险
 *          请注意：此异常并不总是表示对象已被不同的线程同时修改。如果单个线程发出一系列违反对象约定的方法调用，则该对象可能会抛出此异常。
 *          例如：如果线程在使用快速失败迭代器迭代集合时是直接修改了集合，则会抛出此异常
 *          请注意：不能保证快速失败的行为，因为一般来说，在存在不同步的并发修改的情况下，不可能出现任何硬保证。快速失败的操作ConcurrentModificationException
 *          是在尽力而为的基础上进行的，因此，编写一个依赖于此异常的正确性的程序是错误的:ConcurrentModificationException应该只用于检测错误。
 */
public class IteratorDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add("hello");
        c1.add("hogwarts");
        c1.add(Integer.valueOf(77));
        c1.add(88);
        c1.add(new Person("小八",178, 23));
        System.out.println("集合C1： "+ c1);

        System.out.println("----------------遍历打印-------------");
        Iterator iterator1 = c1.iterator();
        boolean hasNext = iterator1.hasNext();
        System.out.println(iterator1.next());

        Iterator iterator2 = c1.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            if (iterator2.hasNext()){
                stringBuilder.append(next).append(",").append(" ");
            }else {
                stringBuilder.append(next);
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
        System.out.println("-------------迭代器删除88----------");
        iterator2 = c1.iterator();
        stringBuilder = new StringBuilder();
        stringBuilder.append("[");
//        while (iterator2.hasNext()){
//            Object next = iterator1.next();
//            System.out.println(next);
//            if ("collection".equals(next)){
//                System.out.println("要删除的对象元素是： "+ next);
//                iterator2.remove();
//            }
//        }
//        System.out.println("C1集合：" + c1);

        System.out.println("---------------迭代器整个删除");
        iterator1 = c1.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            System.out.println(next);
            iterator1.remove();
        }
        System.out.println("C1集合：" + c1);


    }
}
