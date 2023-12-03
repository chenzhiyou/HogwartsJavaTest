package learn.ch12_interface;

public class InAbstractMethodImpl implements InAbstractMethod{
    @Override
    public void eat() {
        System.out.println("实现eat抽象方法");
    }

    @Override
    public void drink() {
        System.out.println("实现drink抽象方法");
    }
}
