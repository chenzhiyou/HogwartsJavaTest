package learn.ch16_inner;

public class InnerMain {
    public static void main(String[] args) {
        // 外部类实例化
        NormalInnerDemo normalInnerDemo = new NormalInnerDemo();
        // 内部类实例化
        NormalInnerDemo.NormalInner normalInner = normalInnerDemo.new NormalInner();
        normalInner.show();
        // 局部优先原则
        normalInner.show2(3); // 局部优先原则

        System.out.println("==========静态内部类============");
        // 外部类名.内部类名 内部类实例名 = new 外部类名.内部类名();
        StaticInnerDemo.StaticInner staticInner = new StaticInnerDemo.StaticInner();
        staticInner.show();
        staticInner.show2(5);

        System.out.println("==========局部内部类============");
        AreaInnerDemo areaInnerDemo = new AreaInnerDemo();
        areaInnerDemo.show();


    }
}
