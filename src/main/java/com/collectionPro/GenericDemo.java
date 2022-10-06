package com.collectionPro;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 泛型
 */
public class GenericDemo {
    public static void main(String[] args) {
        Collection col = new ArrayList();// 可变长度
        col.add(123);// 向上转型 int ---> Integer ---> Object
        col.add(true);
        col.add("hello");
        col.add(23);
        int sum = 0;
        for (Object obj : col){
            if (obj instanceof Integer){// 需要进行类型的判断
                Integer num = (Integer)obj; // 需要向下转型
                sum += num;
            }
        }
        System.out.println("所有数字的和： "+ sum);

        // 使用泛型的方式规定集合中可以存放的数据类型
        Collection<Integer> collection = new ArrayList<>();
        collection.add(123);
        collection.add(23);
        // 自定义泛型
    }
}
