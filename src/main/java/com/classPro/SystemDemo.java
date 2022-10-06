package com.classPro;

import java.util.Arrays;
class Student{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("对象垃圾回收之前调用");
    }
}

public class SystemDemo {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44, 55};
        int[] newArr = new int[5];
        // arraycopy 数组复制
        System.arraycopy(arr, 2, newArr, 0, 3);
        System.out.println(Arrays.toString(newArr));

        new Student();
        new Student();
        new Student();
        System.gc(); // 进行垃圾回收

        // 退出JVM
        System.exit(0);
        System.out.println("hello ");
    }
}
