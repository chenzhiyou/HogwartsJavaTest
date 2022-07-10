package com.hogwarts.ch24_list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List arrayList = new ArrayList<>();
        arrayList.add(2);
        // 动态扩容1.5倍，一次性会首先申请10个内存地址，然后再进行动态内存地址的扩容
    }
}
