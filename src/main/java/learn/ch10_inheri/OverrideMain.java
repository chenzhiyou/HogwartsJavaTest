package learn.ch10_inheri;

public class OverrideMain {
    public static void main(String[] args) {
        OverrideSub overrideSub = new OverrideSub();
        overrideSub.live();
        overrideSub.doSuper();
        overrideSub.doThis();
    }
}
