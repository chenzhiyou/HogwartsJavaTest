package com.hogwarts.ch16_accessPermission.one;

public class Son extends Father{
    public static void main(String[] args) {
        Father father = new Father();
//        father.show1();
        father.show2();
        father.show3();
        father.show4();
        Son son = new Son();
        son.show2();
        son.show3();
        son.show4();
    }
}
