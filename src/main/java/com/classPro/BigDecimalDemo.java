package com.classPro;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        double d1 = 1.0;
        double d2 = 0.9;
        System.out.println("d1-d2= "+ (d1-d2) );
        System.out.println("d1+d2= "+ (d1+d2) );
        // 对于精度要求很高，double 无法精确
        // 用BigDecimal
        BigDecimal b1 = new BigDecimal("1.0");
        BigDecimal b2 = new BigDecimal("0.9");
        BigDecimal add = b1.add(b2);
        BigDecimal sub = b1.subtract(b2);
        System.out.println(add);
        System.out.println(sub);
        BigDecimal b3 = new BigDecimal("3");
        BigDecimal divide = b1.divide(b3,2, BigDecimal.ROUND_UP);
        System.out.println(divide);

    }
}
