package com.hogwarts.ch17_static;

public class ReverseList {
    int num1 = 15;
    static int num2 = 25;

    public void show(){
        // 不能在静态方法中打印输出非静态的变量
        System.out.println(num1);
        System.out.println(num2);
    }

    public static void show1(){
        // 不能在静态方法中打印输出非静态的变量
//        System.out.println(num1);
        System.out.println(num2);
    }

    /**
     * 反转数组中的元素
     * int[] arrays = {1, 3, 5, 7,9}
     * indexLast = length - 1
     * 明确交换内容和交换次数
     */
    public static void reverse(int[] arrays){
        for (int i = 0; i<(arrays.length/2); i++){
            int temp =arrays[i];
            arrays[i] = arrays[arrays.length -1 -i];
            arrays[arrays.length -1 -i] = temp;
        }
    }

}
