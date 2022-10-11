package com.threadPro;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * HashMap对应的线程安全的类：ConcurrentHashMap
 * 初始容量默认为16段(segment)
 * 使用分段锁设计的，不对整个map加锁，而是为每个segment加锁，当多个对象存入同一个segment时，才需要互斥
 * 最理想状态为16个对象分班存入16个segment，并行数量为16
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        for (int i = 0; i< 5; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j< 10;j++ ){
                        map.put(Thread.currentThread().getName()+ "------->"+ j, j+"");
                        System.out.println(map);
                        // 可能会产生：ConcurrentModificationException 并发修改异常
                    }
                }
            }).start();
        }
    }
}
