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


    }
}
