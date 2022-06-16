package com.hogwarts.ch06_method;

/**
 * 方法的声明
 */
public class MethodDeclare {
    public static void main(String[] args) {
        int sumNumber = sum(4,5);
        System.out.println(sumNumber);
    }

    /**
     * 计算求和的方法
     * @param x
     * @param y
     * @return
     */
    public static int sum(int x, int y){
        return x+y;
    }
}
