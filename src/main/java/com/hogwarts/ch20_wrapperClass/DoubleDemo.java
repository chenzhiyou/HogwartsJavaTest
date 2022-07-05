package com.hogwarts.ch20_wrapperClass;

/**
 * Double：
 *      实现对double类型的包装
 *      提供double类型大String类之间的转换等方法
 *      doubleValue 拆箱， Double->double
 *      parseDouble String -> double
 *      isNaN 判断值是否为非数字
 */
public class DoubleDemo {
    public static void main(String[] args) {
        Double d1 = new Double(7.9);
        Double d2 = new Double("10.2");

        System.out.println(d1);
        System.out.println(d2);

        Double d3 = Double.valueOf("7.8");
        Double d4 = Double.valueOf("10.1");

        System.out.println(d3);
        System.out.println(d4);

        double d6 = Double.parseDouble("3.151332");
        System.out.println(d6);
    }
}
