package com.collectionPro;

public class TestPointGeneric {
    public static void main(String[] args) {
        // 在创建对象的时候，确定泛型的类型
        PointGeneric<Integer> pointGeneric = new PointGeneric<>();
        pointGeneric.setX(3);
        pointGeneric.setY(100);
//        pointGeneric.setY(10.0); 添加小数的时候是会报错的
        PointGeneric<String> pointGenericStr = new PointGeneric<>();
        pointGenericStr.setY("23");
        pointGenericStr.setY("100");

        // 定义在方法上的泛型，要在调用方法的时候确定
        pointGeneric.getValue("hello");
        pointGeneric.getValue(100);

    }
}
