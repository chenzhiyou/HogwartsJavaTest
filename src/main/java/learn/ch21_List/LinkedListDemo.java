package learn.ch21_List;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    public static void main(String[] args) {
        List linkedList = new LinkedList<>();
        // 添加元素
        linkedList.add("hello");
        System.out.println("linkedList的元素是： " + linkedList);
    }
}
