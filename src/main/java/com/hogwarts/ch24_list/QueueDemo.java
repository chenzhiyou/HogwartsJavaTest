package com.hogwarts.ch24_list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 是Collection集合的子集合，与List集合属于平级
 * Queue集合的主要描述先进先出特征的数据结构，叫做队列
 * 该集合的主要实现类是LinkedList类
 * boolean offer(E e) 元素放入队列中，添加成功返回true
 * E poll 出队元素，队首删除并返回删除的元素
 * E peek() 队列首尾元素不删除
 */
public class QueueDemo {
    public static void main(String[] args) {
        Queue queue = new LinkedList();
        for (int i =1; i < 6; i++){
            boolean offer = queue.offer(i * 11);
        }
        System.out.println("队列为："+ queue);
        System.out.println("队首元素为： "+ queue.peek());
        int size = queue.size();
        for (int i =0; i< size; i++){
            queue.poll();
        }
        System.out.println("队列为："+ queue);
    }
}
