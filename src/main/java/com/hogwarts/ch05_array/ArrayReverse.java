package com.hogwarts.ch05_array;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] oldArr = {10, 20, 30, 40, 50};
        int[] newArr = new int[oldArr.length];
        for (int i = 0; i < oldArr.length; i++){
            newArr[i] = oldArr[oldArr.length-1 - i ] ;
            System.out.println(newArr[i]);
        }

    }
}
