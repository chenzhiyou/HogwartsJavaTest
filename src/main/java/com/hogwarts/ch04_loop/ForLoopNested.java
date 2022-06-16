package com.hogwarts.ch04_loop;

/**
 * 打印九九乘法表
 */
public class ForLoopNested {
    public static void main(String[] args) {
        for (int i =1; i < 10; i++){
            for ( int j =1; j <=i; j++){
                System.out.print(j + "*" + i + "=" + j*i+ "\t");
            }
            System.out.println();
        }
    }
}
