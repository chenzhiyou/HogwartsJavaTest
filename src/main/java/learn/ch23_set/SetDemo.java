package learn.ch23_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        Set s1 = new HashSet();
        System.out.println("s1: "+ s1);
        s1.add("two");
        s1.add("one");
        s1.add("three");
        System.out.println("s1: "+ s1);
        s1.add("one");
        System.out.println("s1: "+ s1);
    }
}
