package learn.ch21_List;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // List集合声明
        List list = new ArrayList<>();
        // 添加元素 Collection
        list.add("one");
        list.add("two");

        System.out.println("list中的元素为： "+ list);

        System.out.println("==========List中添加元素===========");
        list.add(2, "three");
        list.add(3, "four");
        list.add(1, 1); // 指定位置添加元素

        // addAll()
        List list1 = new ArrayList<>();
        list1.add("hello");
        list1.add("list");
        list1.add("two");
        System.out.println("list1中的元素为： "+ list1);
        list.addAll(4,list1);// 集合中可以添加重复元素
        System.out.println("list中的元素为： "+ list);

        System.out.println("==========List中get方法===========");
        System.out.println(list.get(3)); // 获取指定位置元素
        for (int i = 0; i<list.size(); i++){
            if (i ==0){
                System.out.print("["+ list.get(i)+", ");
            }else if ((list.size()-1) ==i){
                System.out.print(list.get(i) + "]");
            }else {
                System.out.print(list.get(i)+ ", ");
            }
        }
        System.out.println("==========元素出现的位置===========");
        int index = list.indexOf("hello");
        System.out.println("元素出现的位置: "+ index);
        System.out.println("最后一次元素出现的位置: "+ list.lastIndexOf("two"));

        System.out.println("==========set修改元素===========");
        list.set(3,2);
        System.out.println("list中的元素为： "+ list);

        System.out.println("==========删除元素===========");
        for (int i = list.size()-1; i >=0; i--){
            list.remove(i);
        }
        System.out.println("list中的元素为： "+ list);
    }
}
