package learn.ch21_List;

import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {
        List c1 = new ArrayList<>();
        // 首次添加元素，第一次申请内存空间，直接申请10个，之后动态扩容1.5倍
//        arrayList.add(2);
        c1.add("one");
        c1.add(2);
        c1.add("three");
        c1.add(4);

        List c2 = new ArrayList();
        c2.add("three");
        c2.add(4);
        System.out.println(c1.containsAll(c2));
        System.out.println(c1.contains(c2));

//        String str1 = new String("Good Good Study,Day Day Up!");
//        int pos = str1.lastIndexOf("Day", 15);
//        System.out.println("pos= "+ pos);
        String str1 = new String("Good Good Study, Day Day Up!");
        int pos = str1.lastIndexOf("Day", 15);
        System.out.println("pos = " + pos);
    }
}
