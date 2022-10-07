package com.collectionPro;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

class Cat{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Cat() {
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
public class SetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        // 添加
        set.add("hello");
        set.add("world");
        set.add("zhangsan"); // 无法放入重复的元素
        System.out.println("set: " + set);

        // 遍历
        for (String str : set){
            System.out.println("str: " + str);
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            String next = it.next();
            System.out.println("next: "+ next);
        }

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(3);
        System.out.println("set2: " + set2);

        // 自定义类型:如果希望自定义类型的成员相同的时候，不要重复添加到set集合中，需要重新hashCode()和equals()方法
        Set<Cat> catSet = new HashSet<>();
        catSet.add(new Cat("hellojity1", 2));
        catSet.add(new Cat("hellojity2", 2));
        catSet.add(new Cat("hellojity3", 2));
        catSet.add(new Cat("hellojity1", 2));
        System.out.println("catSet: "+ catSet);

    }
}
