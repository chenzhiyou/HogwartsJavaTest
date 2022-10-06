package com.classPro;

class Person{
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

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Demo {
    // 按值传递和按址传递

    /**
     * 基本数据类型 按值传递
     * 引用数据类型 按址传递
     * @param num
     */
    public static void changeNum(int num){
        num = 34;

    }

    public static void changePerson(Person person){
        person.setAge(35);
        person.setName("小黄鸭");
    }
    public static void main(String[] args) {
        int num = 10;
        changeNum(num);
        System.out.println("改变之后num： "+ num);

        Person p1 = new Person("周杰伦", 30);
        changePerson(p1);
        System.out.println(p1.toString());
    }
}
