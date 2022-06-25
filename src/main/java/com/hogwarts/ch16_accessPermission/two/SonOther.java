package com.hogwarts.ch16_accessPermission.two;

import com.hogwarts.ch16_accessPermission.one.Father;

public class SonOther extends Father {
    public static void main(String[] args) {
        Father father = new Father();
//        father.show1();
//        father.show2();
//        father.show3();
        father.show4();
        SonOther sonOther = new SonOther();
        sonOther.show3();
        sonOther.show4();
    }
}
