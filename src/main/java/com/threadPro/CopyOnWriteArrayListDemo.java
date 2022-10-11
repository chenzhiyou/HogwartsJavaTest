package com.threadPro;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CopyOnWriteArrayList 线程安全的ArrayList，加强版读写分离
 * 写有锁，读无锁，读写之间不阻塞，优于读写锁
 * 写入时，先copy一个容器副本，再添加新元素，最后替换引用
 * CopyOnWriteArrayList使用一种叫写时复制的方法，当有新元素添加到CopyOnWriteArrayList时，先从原有的数组中拷贝一份出来，
 * 然后在新的数组做写操作，写完之后，再将原来的数组引用指向到新数组
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        // 线程安全的集合
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        ExecutorService pool = Executors.newFixedThreadPool(5);
        for (int i = 0; i<5; i++){
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    for (int j =0; j<10; j++){
                        list.add("content" + new Random().nextInt(1000));
                    }
                }
            });
        }
        pool.shutdown();
        System.out.println("元素个数: "+ list.size());
        for (String str: list){
            System.out.println(str);
        }
    }
}
