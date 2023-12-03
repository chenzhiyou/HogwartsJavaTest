package learn.ch12_interface;

public interface MultiRuleAbstractTwo {
    public abstract void sameName();
    public abstract void two();

    public default void fore(){};
    public default void sameNameOne(){};
}
