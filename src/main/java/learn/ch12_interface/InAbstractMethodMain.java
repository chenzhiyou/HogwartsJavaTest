package learn.ch12_interface;

public class InAbstractMethodMain {
    public static void main(String[] args) {
        InAbstractMethodImpl inAbstractMethod = new InAbstractMethodImpl();
        inAbstractMethod.drink();
        inAbstractMethod.eat();

        InDefaultMethodImpl inDefaultMethod = new InDefaultMethodImpl();
        inDefaultMethod.walk();

        // 接口静态方法，直接使用接口名称实现调用
        InStaticMethod.study();

        // 接口多实现
        MultiRuleAbstractImpl multiRuleAbstract = new MultiRuleAbstractImpl();
        multiRuleAbstract.sameName();
        multiRuleAbstract.one();
        multiRuleAbstract.two();
        multiRuleAbstract.three();
        multiRuleAbstract.fore();
        multiRuleAbstract.sameNameOne();

        // 子类同时继承父类和实现接口
        PriStudent priStudent = new PriStudent();
        priStudent.study();
    }
}
