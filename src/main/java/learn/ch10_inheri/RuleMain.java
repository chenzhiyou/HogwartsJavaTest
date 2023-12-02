package learn.ch10_inheri;

public class RuleMain {
    public static void main(String[] args) {
        RuleBase ruleBase = new RuleBase();
        RuleSub ruleSub = new RuleSub();

        ruleSub.name = "子类";
        ruleSub.eat();

        ruleBase.name = "父类";

    }
}
