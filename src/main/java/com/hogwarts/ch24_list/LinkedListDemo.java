package com.hogwarts.ch24_list;

import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList类的底层是采用的双向链表进行数据管理的
 * 访问不方便，访问需要一个个遍历查看
 * 增删元素方便
 * 链表特点：
 *      链表的每个元素被称为结点
 *      结点组成部分：
 *          结点的存储位置：地址
 *          存储的具体数据
 *          下一个节点的地址
 */
public class LinkedListDemo {
    public static void main(String[] args) {
        List linkList = new LinkedList<>();
        linkList.add("hello");

        System.out.println(linkList);
    }
}
