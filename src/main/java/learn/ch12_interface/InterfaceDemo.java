package learn.ch12_interface;

public interface InterfaceDemo {

    // 常量
    public static final int age = 20;

    //抽象方法
    public abstract void eat();

    // 默认方法
    public default void run(){
        System.out.println("这是一个default方法");
    }

    // 静态方法
    public static void jump(){
        System.out.println("这是一个静态方法");
    }

    // 私有方法
    default void walk(){
        System.out.println("这是一个私有方法");
    }
}
