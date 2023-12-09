package learn.ch07_oop;

/**
 * Person类
 */
public class Person {
    // 属性
    public float height;
    public static String name;
    public Integer age;

    public Person(){
        // 构造方法
    }
    public Person(float height, String name, Integer age){
        this.age = age;
        this.height = height;
        this.name = name;
    }

    // 行为
    public static void eat(){
        System.out.println("eat方法");
    }
    public static void sleep(){
        System.out.println("sleep方法");
    }
    public static void work(){
        System.out.println("work方法");
    }

    public static void show(int i){
        System.out.println("show方法中的i为：" + i);
    }

    public static void meet(String meetPersonName){
        System.out.println(name + "遇见了" + meetPersonName);
    }

    public static void main(String[] args) {
        Person xp = new Person();
        xp.height= 1.83f;
        xp.name = "小李";
        xp.age = 23;
        xp.eat();
        xp.sleep();
        xp.work();
        xp.meet("小王");

    }
}
