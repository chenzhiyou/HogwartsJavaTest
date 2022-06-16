package com.hogwarts.ch12_interface;

public class InDefaultMethodImpl implements InDefaultMethod{
    public void walk(){
//      调用接口中的被重写的方法
        InDefaultMethod.super.walk();
        System.out.println("被重写后的walk方法");
    }

    public void eat(){

    }
}
