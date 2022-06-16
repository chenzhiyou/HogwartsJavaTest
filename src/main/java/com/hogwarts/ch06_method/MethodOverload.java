package com.hogwarts.ch06_method;

public class MethodOverload {
    public static int sum(int a, int b){
        System.out.println("有2个参数参加");
        return a + b;
    }

    public static int sum(int a ,int b , int c){
        System.out.println("有3个参数参加");
        return a + b + c;
    }


    public static void main(String[] args) {
        sum(5, 10);
        sum(3, 4, 5);
    }
}
