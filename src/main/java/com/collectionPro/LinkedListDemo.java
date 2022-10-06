package com.collectionPro;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("123");
        list.addFirst("234");
        list.addLast("hello");
        list.addFirst("true");
        System.out.println("list: "+ list);
        // 弹出一个元素 先入后出
        System.out.println(list.pop());
    }
}
