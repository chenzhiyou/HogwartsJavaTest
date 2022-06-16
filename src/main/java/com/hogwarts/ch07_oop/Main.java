package com.hogwarts.ch07_oop;

public class Main {
    public static void main(String[] args) {
        String[] nameArray = {"张三", "李四", "王五"};
        System.out.println(nameArray);
        System.out.print("[");
        for (int i =0; i<nameArray.length; i++){
            System.out.print(nameArray[i]);
            if (i != nameArray.length -1){
                System.out.print(",");
            }else {
                System.out.print("]");
            }
        }
    }
}
