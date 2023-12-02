package learn.ch10_inheri;

public class HiddenSub extends HiddenBase{
    public String name = "子类的name变量";
    public void showSuper(){
        System.out.println("super " + super.name);
    }

    public void showThis(){
        System.out.println("this " + this.name);
    }
}
