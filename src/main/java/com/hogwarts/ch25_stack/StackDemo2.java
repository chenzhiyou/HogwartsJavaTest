package com.hogwarts.ch25_stack;

import java.util.Stack;

public class StackDemo2 {
    public static void main(String[] args) {
        Stack stack = new Stack();
        for(int i =1; i< 6; i++){
//            System.out.println(i*11);
            // 入栈
            stack.push(i*11);
            System.out.println("当前入栈元素为： "+ i*11);
        }
        System.out.println("stack集合为："+ stack);
        System.out.println("栈顶元素为： "+ stack.peek());
        int size = stack.size();
        Stack stack1 = new Stack();
        for (int i = size; i >0; i--){
            Object pop = stack.pop();
            System.out.println("出栈元素为："+ pop);
            Object push = stack1.push(pop);
            System.out.println("stack1入栈元素为： "+ push);
        }
        System.out.println("stack集合为："+ stack);
        System.out.println("stack1集合为："+ stack1);
    }
}
