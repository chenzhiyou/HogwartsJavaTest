package learn.ch12_interface;

public class InDefaultMethodImpl implements InDefaultMethod{
    public void walk(){
        // 调用接口的被重写的方法
        InDefaultMethod.super.walk();
        System.out.println("实现类重写后的walk");
    }
}
