package learn.ch12_interface;

public interface InDefaultMethod {
    // 默认方法
    public default void run(){
        System.out.println("接口默认方法run");
    }

    public default void walk(){
        System.out.println("接口默认方法walk");
    }
}
