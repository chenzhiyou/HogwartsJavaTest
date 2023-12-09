package learn.ch20_foreach;

import com.hogwarts.ch07_oop.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ForEachDemo {
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
        System.out.println("==============forEach方式打印================");
        for (Object collection: c1){
            System.out.println(collection);
        }

        int[] arr = new int[]{22,33,44,55,66};
        for (int i :arr){
            System.out.println("数组内容为:" + i);
            i = 77;
        }
        System.out.println("数组打印： "+ Arrays.toString(arr));
    }
}
