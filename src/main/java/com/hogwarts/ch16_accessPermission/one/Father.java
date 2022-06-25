package com.hogwarts.ch16_accessPermission.one;

/**
 * 四种权限修饰符
 * 本类 本包 子类 其他类
 */
public class Father {
    private void show1(){
        System.out.println("private show1");
    }

    void show2(){
        System.out.println("默认 show2");
    }

    protected void show3(){
        System.out.println("protected show3");
    }

    public void show4(){
        System.out.println("public show4");
    }

    public static void main(String[] args) {
        Father father = new Father();
        father.show1();
        father.show2();
        father.show3();
        father.show4();
    }
}
