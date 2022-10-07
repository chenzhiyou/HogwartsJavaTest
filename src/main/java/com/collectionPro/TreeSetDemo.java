package com.collectionPro;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Bird implements Comparable<Bird>{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Bird(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    // 比较的方法
    @Override
    public int compareTo(Bird bird) {
        if (this.getAge()> bird.getAge()){
            return 1;
        }else if (this.getAge()< bird.getAge()){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Bird{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class TreeSetDemo {
    public static void main(String[] args) {
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("aaaa");
        treeSet.add("bbbb");
        treeSet.add("dddd");
        treeSet.add("cccc");
        System.out.println("treeSet: " + treeSet);

        Set<Bird> birdSet = new TreeSet<>();
        birdSet.add(new Bird("小黄", 1));
        birdSet.add(new Bird("小绿", 2));
        birdSet.add(new Bird("小蓝", 3));
        System.out.println("birdSet: " + birdSet);

        // 使用自定义的比较器
        Set<Bird> birdSet1 = new TreeSet<>(new Comparator<Bird>() {
            @Override
            public int compare(Bird o1, Bird o2) {
                if (o1.getAge()> o2.getAge()){
                    return 1;
                }else if (o1.getAge()< o2.getAge()){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        birdSet1.add(new Bird("小黄", 1));
        birdSet1.add(new Bird("小绿", 2));
        birdSet1.add(new Bird("小蓝", 3));
        System.out.println("birdSet1: " + birdSet1);

    }
}
