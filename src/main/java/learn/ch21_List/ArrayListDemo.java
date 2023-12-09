package learn.ch21_List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List arrayList = new ArrayList<>();
        // 首次添加元素，第一次申请内存空间，直接申请10个，之后动态扩容1.5倍
        arrayList.add(2);
    }
}
