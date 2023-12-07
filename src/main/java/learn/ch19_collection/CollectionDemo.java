package learn.ch19_collection;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class CollectionDemo {
    public static void main(String[] args) {
//        Collection c1 = new Collection<>()
        // 使用多态的方式进行声明
        Collection c1 = new ArrayList();
        c1.add(new String("hello"));
        c1.add("collection");
        c1.add(Integer.valueOf(77));
        c1.add(88);
        // 添加对象
        Person xiaoP  = new Person("name", 190, 23);
        c1.add(xiaoP);
        System.out.println("集合c1: "+ c1);
        Collection c2 = new ArrayList();
        c2.add(86);
        c2.add("java");

        c2.addAll(c1);
        c2.add(c1);
        c1.addAll(c2);
        System.out.println("集合c2: "+ c2);
        System.out.println("是否包含： " +c1.contains("hello"));
        System.out.println("是否包含： " +c1.contains("hogwarts"));
        System.out.println("是否包含： " +c1.contains(88));
        System.out.println("是否包含： " +c1.contains(8));
        System.out.println("是否包含： " +c1.contains(new Person("name", 190, 23)));
        System.out.println("是否包含： " +c1.contains(xiaoP));
        System.out.println("是否包含： " +c1.containsAll(c2));
        System.out.println("是否包含： " +c1.containsAll(c1));
        System.out.println("删除是否成功： "+ c1.remove(66));
        System.out.println("删除是否成功： "+c1.remove(xiaoP));
        System.out.println("删除是否成功： "+c1.remove(xiaoP));
        System.out.println("集合c1: "+ c1);
        Collection collection = new ArrayList();
        collection.add(29);
        collection.add("hello");
        System.out.println(c1.removeAll(collection));// 只要有一个元素被删除，就会返回true
        System.out.println("c1的长度为： "+ c1.size());
        System.out.println("集合是否为空： "+ c1.isEmpty());
        Object[] toArray =  c1.toArray();
        Collection obList = Arrays.asList(toArray);// 数组转换为集合
        System.out.println("集合转换为数组: "+ Arrays.toString(c1.toArray()));

        c1.clear();
        System.out.println("集合c1: "+ c1);

    }
}
