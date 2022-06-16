package com.hogwarts.ch10_inheri;

public class OverrideSub extends OverrideBase{
    public void live(){
        System.out.println("子类方法：住在新家");
    }

    public void doSuper(){
        super.live();
    }

    public void doThis(){
        this.live();
    }
}
