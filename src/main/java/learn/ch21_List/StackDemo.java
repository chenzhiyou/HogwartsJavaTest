package learn.ch21_List;

import java.util.Stack;

public class StackDemo {
    public static void main(String[] args) {
        // 声明Stack集合
        Stack stack = new Stack();
        // 入栈元素
        for (int i = 1; i<6; i++){
            Object push = stack.push(i * 11);
            System.out.println("当前入栈元素为： "+ push);
        }

        Stack stack1 = new Stack();

        System.out.println("stack集合为： "+ stack);
        // 查看栈顶元素：
        System.out.println("栈顶元素为： "+ stack.peek());
        int num = stack.size();
        for (int i =0; i<num; i++){
            Object s = stack.pop();
            System.out.println("当前出栈元素为： "+ s);
            stack1.push(s);
        }
        System.out.println("stack集合为： "+ stack);
        System.out.println("stack1集合为： "+ stack1);
    }
}
