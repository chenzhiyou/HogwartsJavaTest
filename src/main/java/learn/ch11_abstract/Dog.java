package learn.ch11_abstract;

public class Dog extends Animals{
    // 在具体子类中重写抽象方法
    @Override
    public void eat() {
        System.out.println("小狗狗吃狗粮");
    }
}
