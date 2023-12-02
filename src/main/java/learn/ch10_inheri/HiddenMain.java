package learn.ch10_inheri;

public class HiddenMain {
    public static void main(String[] args) {
        HiddenSub hiddenSub = new HiddenSub();
        System.out.println(hiddenSub.name);
        hiddenSub.showSuper();
        hiddenSub.showThis();
    }
}
