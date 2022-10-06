package com.collectionPro;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        // 添加元素, 有序可重复
        list.add(0, 100);
        list.add(1, 100);
        list.add(2, 20);
        list.add(3, 200);
        System.out.println("list: " + list );
        // 获取元素
        Integer ele = list.get(2);
        System.out.println("2号元素为： " + ele);
        // 修改
        list.set(2, 100);
        System.out.println("修改后的list集合: " + list );
        // 删除
        list.remove(2);
        System.out.println("删除后的list集合: " + list );
    }
}
