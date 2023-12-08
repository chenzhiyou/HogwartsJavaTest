package learn.ch19_collection;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class IteratorDemo {
    public static void main(String[] args) {
        Collection c1 = new ArrayList();
        c1.add(new String("hello"));
        c1.add("collection");
        c1.add(Integer.valueOf(77));
        c1.add(88);
        // 添加对象
        Person xiaoP  = new Person("name", 190, 23);
        c1.add(xiaoP);
        System.out.println("集合c1: "+ c1);
        // 迭代器打印
        Iterator iterator = c1.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        while (iterator.hasNext()){
            Object next = iterator.next();
            if (iterator.hasNext()){
                stringBuilder.append(next).append(",").append(" ");
            }else {
                stringBuilder.append(next).append("]");
            }
        }
        System.out.println(stringBuilder);
        iterator = c1.iterator();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("[");
        while (iterator.hasNext()){
            Object next = iterator.next();
            if (next.equals(88) ){
                iterator.remove();
                continue;
            }else {
                if (iterator.hasNext()){
                    stringBuilder2.append(next).append(",").append(" ");
                }else {
                    stringBuilder2.append(next).append("]");
                }
            }
        }
        System.out.println(c1);
        System.out.println(stringBuilder2);
    }
}
