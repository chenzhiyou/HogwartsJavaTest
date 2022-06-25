package com.hogwarts.ch17_static;

public class ReverseListDemo {
    public static void main(String[] args) {
        ReverseList reverseList = new ReverseList();
        reverseList.show();
        ReverseList.show1();

        int[] arr = {1, 3,  7, 9};
        for (int ar : arr) {
            System.out.print(ar + ",");
        }
        System.out.println("数组开始转换");
        ReverseList.reverse(arr);
        for (int ar : arr) {
            System.out.print(ar + ",");
        }

    }
}
