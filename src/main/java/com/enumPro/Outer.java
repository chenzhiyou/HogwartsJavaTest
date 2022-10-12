package com.enumPro;

public class Outer {
    private int outerVariable = 1;
    private int commonVariable = 2;
    private static int outerStaticVariable = 3;

    /**
     * 成员方法
     */
    public void outerMethod(){
        System.out.println("我是外部类的outerMethod方法");
    }

    /**
     * 静态方法
     */
    public static void outerStaticMethod(){
        System.out.println("我是外部类的outerStaticMethod静态方法");
    }

    /**
     * 成员内部类
     */
    public class Inner{
        // 成员内部类的成员变量
        private int commonVariable = 20;
        /**
         * 成员方法
         */

        public Inner(){}

        public void innerShow(){
            System.out.println("commonVariable: "+ commonVariable);
            System.out.println("外部类的commonVariable: "+ Outer.this.commonVariable);
            System.out.println("外部类的成员变量outerVariable： "+outerVariable);
            System.out.println("外部类的静态变量outerStaticVariable：" + outerStaticVariable);
            // 外部类的方法
            outerMethod();
            // 外部类的静态方法
            outerStaticMethod();
        }

        public Inner getInstance(){
            Inner inner = new Inner();
            inner.innerShow();
            return inner;
        }

    }
}
