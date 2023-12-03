package learn.ch12_interface;

public interface MultiRuleAbstractOne {
    public abstract void sameName();
    public abstract void one();

    public default void three(){};
    public default void sameNameOne(){};
}
