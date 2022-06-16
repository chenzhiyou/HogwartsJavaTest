package com.hogwarts.ch05_array;

public class Array2DInitDynamic {
    public static void main(String[] args) {
        int[][] array2DA;
        array2DA = new int[4][3];
        array2DA[0][0] = 23;
        array2DA[0][1] = 89;
        array2DA[0][2] = 12;
        System.out.println(array2DA[0][0]);
        System.out.println(array2DA[0][1]);
        System.out.println(array2DA.length);
    }
}
