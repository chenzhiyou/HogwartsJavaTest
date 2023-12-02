package learn.ch11_abstract;

public class RuleThreeSub extends RuleThree{
    @Override
    public void eat() {
        System.out.println("干饭");
    }

    @Override
    public void drink() {
        System.out.println("喝奶茶");
    }
}
