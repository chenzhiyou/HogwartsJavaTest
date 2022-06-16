package com.hogwarts.ch10_inheri;

public class RuleBase {
    public String name;
    private int money;

    public void eat(){
        System.out.println(this.name + "在吃饭");
    }

    private void showMoney(){
        System.out.println(this.money + "元钱");
    }
}
