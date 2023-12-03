package learn.ch12_interface;

public class MultiRuleAbstractImpl implements MultiRuleAbstractOne, MultiRuleAbstractTwo{
    @Override
    public void sameName() {
        System.out.println("重名的抽象方法只需要重写一次");
    }

    @Override
    public void two() {
        System.out.println("实现two方法");
    }

    @Override
    public void fore() {
        MultiRuleAbstractTwo.super.fore();
    }

    @Override
    public void one() {
        System.out.println("实现one方法");
    }

    @Override
    public void three() {
        MultiRuleAbstractOne.super.three();
        System.out.println("实现默认方法three");
    }

    @Override
    public void sameNameOne() {
//        MultiRuleAbstractOne.super.sameNameOne();
        System.out.println("如果多接口的默认方法重名，则必须重写");
    }
}
