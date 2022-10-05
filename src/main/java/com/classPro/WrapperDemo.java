package com.classPro;

public class WrapperDemo {
    public static void main(String[] args) {
        // 装箱
        Integer i = new Integer(4);
        Integer i2 = Integer.valueOf(56);
        // 可以用面向对象的方式进行编程
        // 拆箱
        int num = i2.intValue();
        System.out.println("num: " + num);

        //自动拆箱和自动装箱
        Integer integer1 = 5; // 自动装箱
        int result = integer1 + 5; // 自动拆箱
        System.out.println("result: " + result);

        // 基本数据类型与字符串之间的转换
        // 基本类型 ---->字符串
        int a = 34;
        String aStr = a+"";
        System.out.println(aStr);
        // 字符串 ----> 基本数据类型
        int aNum = Integer.parseInt(aStr);
        System.out.println(aNum);



    }
}
