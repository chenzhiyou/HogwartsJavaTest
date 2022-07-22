package com.hogwarts.ch25_stack;

import java.util.Stack;

/**
 * E push(E item) 把元素放入栈中
 * boolean empty() 判断堆栈是否为空
 * synchronized int search (Object o) 返回对象在堆栈上的从1开始的位置
 * synchronized E pop() 移除此堆栈顶部的对象并将该对象作为此函数的值返回
 * synchronized E peek() 查看栈顶元素
 */
public class StackDemo {
    public static void main(String[] args) {
        // 声明Stack集合
        Stack stack = new Stack();
        for(int i =1; i< 6; i++){
//            System.out.println(i*11);
            // 入栈
            stack.push(i*11);
            System.out.println("当前入栈元素为： "+ i*11);
        }
        System.out.println("stack集合为："+ stack);
        System.out.println("栈顶元素为： "+ stack.peek());

        int search = stack.search(33);
        System.out.println("33距离栈顶的位置： "+ search);

        // 出栈
        int size = stack.size();
        for (int i = size; i >0; i--){
            System.out.println("出栈元素为："+ stack.pop());
        }
        System.out.println("stack集合为："+ stack);
    }
}
