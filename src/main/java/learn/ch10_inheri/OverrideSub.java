package learn.ch10_inheri;

public class OverrideSub extends OverrideBase{
    // 显示调用super()方法
    public OverrideSub(){
        super(); //调用父类构造
        System.out.println("子类的构造方法");
    }
    public void live(){
        System.out.println("住在新家");
    }

    public void doSuper(){
        super.live();
    }

    public void doThis(){
        this.live();
    }
}
